package com.unclepunkinhead.notekeeper

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Matchers.*
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

internal class CreateNewNoteTest {

    @Rule @JvmField
    val activityScenarioRule = ActivityScenarioRule(NoteListActivity::class.java)

    @Test
    fun createNewNote() {
        val course = DataManager.courses["android_async"]
        val noteTitle = "Test note title"
        val noteText = "This is the body of our test note"

        onView(withId(R.id.fab)).perform(click())
        onView(withId(R.id.spinnerCourses)).perform(click())
        onData(allOf(instanceOf(CourseInfo::class.java), equalTo(course))).perform(click())

        onView(withId(R.id.textNoteTitle)).perform(typeText(noteTitle))
        onView(withId(R.id.textNoteText)).perform(typeText(noteText), closeSoftKeyboard())

        pressBack()

        val newNote = DataManager.notes.last()
        assertEquals(course, newNote.course)
        assertEquals(noteText, newNote.text)
        assertEquals(noteTitle, newNote.title)
    }

}