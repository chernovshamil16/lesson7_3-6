package com.example.lesson7_3.presentation.fragment.notes

import com.example.lesson7_3.domain.model.Note
import com.example.lesson7_3.domain.usecases.DeleteNotesUseCase
import com.example.lesson7_3.domain.usecases.GetNotesUseCase
import com.example.lesson7_3.presentation.base.BaseViewModel
import com.example.lesson7_3.presentation.fragment.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val deleteNotesUseCase: DeleteNotesUseCase
) : BaseViewModel() {

    private val _getNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getNoteState = _getNotesState.asStateFlow()

    private val _deleteNotesState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNoteState = _deleteNotesState.asStateFlow()

    fun getNotes() {
        getNotesUseCase.getNotes().collectFlow(_getNotesState)
    }

    fun deleteNotes(note: Note) {
        deleteNotesUseCase.deleteNotes(note).collectFlow(_deleteNotesState)
    }
}