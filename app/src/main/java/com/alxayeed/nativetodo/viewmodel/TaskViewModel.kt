package com.alxayeed.nativetodo.viewmodel

import TaskEntity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alxayeed.nativetodo.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    // Internal mutable state
    private val _taskList = MutableStateFlow<List<TaskEntity>>(emptyList())

    // External immutable state
    val taskList: StateFlow<List<TaskEntity>> = _taskList.asStateFlow()

    init {
        observeTasks()
    }

    private fun observeTasks() {
        viewModelScope.launch {
            repository.getAllTasks().collectLatest { tasks ->
                _taskList.value = tasks
            }
        }
    }

    fun insertTask(task: TaskEntity) = viewModelScope.launch {
        repository.insertTask(task)
    }

    fun updateTask(task: TaskEntity) = viewModelScope.launch {
        repository.updateTask(task)
    }

    fun deleteTask(task: TaskEntity) = viewModelScope.launch {
        repository.deleteTask(task)
    }

    suspend fun getTaskById(id: Int): TaskEntity? {
        return repository.getTaskById(id)
    }
}
