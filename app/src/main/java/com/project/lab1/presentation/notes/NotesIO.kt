package com.project.lab1.presentation.notes

import com.project.lab1.presentation.notes.models.NoteItem


interface NotesInput {
    fun updateUI(data: Array<NoteItem>)
}

interface NotesOutput {
    fun getNotes(token: String)
}
