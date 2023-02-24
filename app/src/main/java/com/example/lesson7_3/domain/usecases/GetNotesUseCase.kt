package com.example.lesson7_3.domain.usecases

import com.example.lesson7_3.domain.repository.NoteRepository
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun getNotes() = noteRepository.getNote()
}