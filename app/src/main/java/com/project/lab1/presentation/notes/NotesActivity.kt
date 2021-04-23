package com.project.lab1.presentation.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.lab1.databinding.ActivitySeeNotesBinding
import com.project.lab1.presentation.notes.adapters.NoteAdapter
import com.project.lab1.presentation.notes.models.NoteItem
import com.project.lab1.network.APICommunication
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class NotesActivity : NotesInput, AppCompatActivity() {
    private lateinit var binding: ActivitySeeNotesBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var apiService: APICommunication
    private val presenter: NotesOutput by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySeeNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewManager = LinearLayoutManager(this)
        apiService = APICommunication()
        val pref = getSharedPreferences("tokens", MODE_PRIVATE)
        val token = pref.getString("auth", "")

        if (token != null) {
            presenter.getNotes(token)
        }
    }

    override fun updateUI(notes: Array<NoteItem>) {
            viewAdapter = NoteAdapter(notes)
            recyclerView = binding.noteRecyclerView.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
    }
}
