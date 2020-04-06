package com.unclepunkinhead.notekeeper

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_note_list.*
import kotlinx.android.synthetic.main.content_note_list.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            startActivity(Intent(this, MainActivity::class.java))
        }

        listNotes.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, DataManager.notes)

        listNotes.setOnItemClickListener{parent, view, position, id ->
            val activity = Intent(this, MainActivity::class.java)
            activity.putExtra(EXTRA_NOTE_POSITION, position)
            startActivity(activity)
        }
    }
}