package com.alxayeed.nativetodo.viewmodel

import TaskEntity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alxayeed.nativetodo.repository.TaskRepository
import com.alxayeed.nativetodo.util.UiState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    private val _taskListState = MutableStateFlow<UiState<List<TaskEntity>>>(UiState.Loading)
    val taskListState: StateFlow<UiState<List<TaskEntity>>> = _taskListState

    fun loadTasks() {
        viewModelScope.launch {
            repository.getAllTasks()
                .onStart { _taskListState.value = UiState.Loading }
                .catch { e -> _taskListState.value = UiState.Error(e.message ?: "Unexpected error") }
                .collect { tasks ->
                    _taskListState.value = if (tasks.isEmpty()) UiState.Empty else UiState.Success(tasks)
                }
        }
    }

    fun insertTask(task: TaskEntity) {
        viewModelScope.launch {
            repository.insertTask(task)
            loadTasks()
        }
    }

    fun updateTask(task: TaskEntity) {
        viewModelScope.launch {
            repository.updateTask(task)
            loadTasks()
        }
    }

    fun deleteTask(task: TaskEntity) {
        viewModelScope.launch {
            repository.deleteTask(task)
            loadTasks()
        }
    }

    suspend fun getTaskById(id: Int): TaskEntity? {
        return repository.getTaskById(id)
    }
}
