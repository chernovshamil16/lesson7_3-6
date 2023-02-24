package com.example.lesson7_3.domain.usecases

import com.example.lesson7_3.domain.model.Note
import com.example.lesson7_3.domain.repository.NoteRepository
import javax.inject.Inject

class EditNotesUseCase @Inject constructor(private val noteRepository: NoteRepository) {
    
    fun editNotes(note: Note) = noteRepository.editNote(note)
}