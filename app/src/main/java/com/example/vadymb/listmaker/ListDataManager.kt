package com.example.vadymb.listmaker

import android.content.Context
import android.preference.PreferenceManager

class ListDataManager(private val context: Context) {

    fun saveList(list: TaskList) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context).edit()
        prefs.putStringSet(list.name, list.tasks.toHashSet())
        prefs.apply()
    }

    fun readLists(): ArrayList<TaskList> {
        val allPrefs = PreferenceManager.getDefaultSharedPreferences(context).all
        val taskLists = ArrayList<TaskList>()

        for (taskList in allPrefs) {
            val listItems = taskList.value as HashSet<String>
            val list = TaskList(taskList.key, ArrayList(listItems))
            taskLists.add(list)
        }

        return taskLists
    }
}