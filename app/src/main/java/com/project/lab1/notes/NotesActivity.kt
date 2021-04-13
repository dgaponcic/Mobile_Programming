package com.project.lab1.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.databinding.ActivitySeeNotesBinding
import com.project.lab1.notes.adapters.NoteAdapter
import com.project.lab1.notes.models.NoteItem
import com.project.lab1.network.APICommunication
import com.project.lab1.network.models.NoteResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class NotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeeNotesBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var apiService: APICommunication

    private fun getNotes(token: String) {
        GlobalScope.launch {
            kotlin.runCatching {
                apiService.getNotes(token)
            }.onSuccess {
                handleAPIData(it)
            }.onFailure {
                print(it)
            }
        }
    }

    private fun handleAPIData(data: NoteResponse) {
        val notes = data.notes.map { NoteItem(
                it.link)
        }.toTypedArray()

        MainScope().launch {
            viewAdapter = NoteAdapter(notes)
            recyclerView = binding.noteRecyclerView.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySeeNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewManager = LinearLayoutManager(this)
        apiService = APICommunication()
        val pref = getSharedPreferences("tokens", MODE_PRIVATE)
        val token = pref.getString("auth", "")

        if (token != null) {
            getNotes(token)
        }
    }
}
