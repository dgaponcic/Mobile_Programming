package com.project.lab1.presentation.notes

import android.util.Log
import com.project.lab1.network.models.Note
import com.project.lab1.presentation.APIClient
import com.project.lab1.presentation.notes.models.NoteItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class NotesPresenter(val view: NotesInput, val apiService: APIClient): NotesOutput {
    override fun getNotes(token: String) {
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

    fun handleAPIData(data: ArrayList<Note>) {
        val notes = data.map { NoteItem(
            it.link)
        }.toTypedArray()

        MainScope().launch {
            view.updateUI(notes)
        }
    }
}
