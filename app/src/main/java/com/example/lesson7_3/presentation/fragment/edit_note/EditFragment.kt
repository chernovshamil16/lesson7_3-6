package com.example.lesson7_3.presentation.fragment.edit_note

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson7_3.R
import com.example.lesson7_3.databinding.FragmentEditBinding
import com.example.lesson7_3.domain.model.Note
import com.example.lesson7_3.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditFragment : BaseFragment(R.layout.fragment_edit) {

    private val viewModel by viewModels<EditViewModel>()
    private val binding by viewBinding(FragmentEditBinding::bind)
    private var note : Note? = null

    override fun initialize() {

    }

    override fun setupListeners() {
        binding.btnSave.setOnClickListener {
             viewModel.createNotes(Note(
                title = binding.etTitle.text.toString(),
                desc = binding.etDesc.text.toString(),
                createdAd = System.currentTimeMillis()
            ))
        }
    }

    override fun setupSubscribers() {

        viewModel.createNoteState.collectState(
            onLoading = {},

            onError = {
                Toast.makeText(requireContext() , it  , Toast.LENGTH_SHORT).show()
            },

            onSuccess = {
                findNavController().navigateUp()
            }
        )

        viewModel.editNoteState.collectState(
            onError = {
                Toast.makeText(requireContext() , it  , Toast.LENGTH_SHORT).show()
            },

            onLoading = {},

            onSuccess = {
                findNavController().navigateUp()
            }
        )
    }

    companion object {
        const val CREATE_NOTE = "note"
    }

}