package com.example.epoxysectioned.controllers

import android.view.View
import com.airbnb.epoxy.EpoxyController
import com.example.epoxysectioned.itemHeader
import com.example.epoxysectioned.itemTask
import com.example.epoxysectioned.models.Header
import com.example.epoxysectioned.models.Task
import java.util.*


class TaskController : EpoxyController() {

    companion object {


        private var taskLists: ArrayList<Any> = arrayListOf(
            Header("Overdue"),
            Task("Task 1", "1/08/19"),
            Task("Task 2", "1/08/19"),
            Task("Task 3", "1/08/19"),
            Header("Today"),
            Task("Task 4", "2/08/19"),
            Task("Task 5", "2/08/19"),
            Task("Task 6", "2/08/19"),
            Task("Task 7", "2/08/19"),
            Task("Task 8", "2/08/19"),
            Header("Tomorrow"),
            Task("Task 9", "3/08/19"),
            Task("Task 10", "3/08/19"),
            Task("Task 11", "3/08/19"),
            Task("Task 12", "3/08/19"),
            Task("Task 13", "3/08/19"),
            Header("After"),
            Task("Task 14", "4/08/19"),
            Task("Task 15", "4/08/19"),
            Task("Task 16", "4/08/19"),
            Task("Task 17", "4/08/19"),
            Task("Task 18", "4/08/19")
        )

        fun moveTasks(from: Int, to: Int) {
            if(from <= to){
                Collections.rotate(taskLists.subList(from, to+1), -1)
            }
            else{
                Collections.rotate(taskLists.subList(to, from+1), 1)

            }

        }

    }

    override fun buildModels() {


        taskLists.forEach { item ->

            if (item is Header) {
                itemHeader {
                    id(item.id)
                    title(item.title)
                    if (item.title != "Overdue"){
                        rescheduleButtonVisibility(View.GONE)
                    }
                }
            }


            if (item is Task) {
                itemTask {
                    id(item.id)
                    name(item.name)
                    date(item.date)
                }
            }
        }
    }
}

