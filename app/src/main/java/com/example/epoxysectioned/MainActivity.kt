package com.example.epoxysectioned

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.airbnb.epoxy.EpoxyTouchHelper
import com.example.epoxysectioned.controllers.TaskController
import com.example.epoxysectioned.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val taskController = TaskController()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        initRV()

    }

    private fun initRV() {
        binding.rvTaskList.adapter = taskController.adapter
        taskController.requestModelBuild()
        initTouch()
    }

    private fun initTouch() {
        EpoxyTouchHelper.initDragging(taskController)
            .withRecyclerView(binding.rvTaskList)
            .forVerticalList()
            .withTarget(ItemTaskBindingModel_::class.java)
            .andCallbacks(object : EpoxyTouchHelper.DragCallbacks<ItemTaskBindingModel_>() {
                override fun onModelMoved(
                    fromPosition: Int,
                    toPosition: Int,
                    modelBeingMoved: ItemTaskBindingModel_?,
                    itemView: View?
                ) {
                    TaskController.moveTasks(fromPosition, toPosition)
                }
            })
    }
}
