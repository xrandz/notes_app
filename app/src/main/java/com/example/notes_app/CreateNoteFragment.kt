package com.example.notes_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.notes_app.database.NotesDatabase
import com.example.notes_app.entities.Notes
import kotlinx.android.synthetic.main.fragment_create_note.*
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.coroutines.launch

class CreateNoteFragment : BaseFragment() {
    var currentDate:String?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            CreateNoteFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sdf = SimpleDateFormat("dd/MM/yyyy hh::mm:ss")
        currentDate = sdf.format(Date())

        tvDateTime.text = currentDate

        imgDone.setOnClickListener {
            //
            saveNote()
        }

        imgBack.setOnClickListener {
            replaceFragment(HomeFragment.newInstance(),false)
        }


    }

    private fun saveNote(){

        // add validation on all editText fields
        if(etNoteTitle.text.isNullOrEmpty()){
            Toast.makeText(context, "Title is Required",Toast.LENGTH_SHORT).show()
        }

        if(etNoteSubTitle.text.isNullOrEmpty()){
            Toast.makeText(context, "Note Subtitle is Required",Toast.LENGTH_SHORT).show()
        }

        if(etNoteDesc.text.isNullOrEmpty()){
            Toast.makeText(context, "Note Description is Required", Toast.LENGTH_SHORT).show()
        }

        //  part of coroutine function
        launch {
            var notes = Notes()
            notes.title = etNoteTitle.text.toString()
            notes.subTitle = etNoteSubTitle.text.toString()
            notes.noteText = etNoteDesc.text.toString()
            notes.dateTime = currentDate
            context?.let {
                NotesDatabase.getDatabase(it).noteDao().insertNotes(notes)
                etNoteTitle.setText("")
                etNoteSubTitle.setText("")
                etNoteDesc.setText("")
            }
        }

    }


    // requireActivity is a replace for null activity!! objcect -> part 3:7:24
    fun replaceFragment(fragment: Fragment, istransition:Boolean){
        val fragmentTransition = requireActivity().supportFragmentManager.beginTransaction()

        if(istransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right, android.R.anim.slide_in_left)
        }
        fragmentTransition.replace(R.id.frame_layout,fragment).addToBackStack(fragment.javaClass.simpleName)

    }
}