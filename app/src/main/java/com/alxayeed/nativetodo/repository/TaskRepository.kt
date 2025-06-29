package com.alxayeed.nativetodo.repository

import TaskDao
import TaskEntity
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {

    fun getAllTasks(): Flow<List<TaskEntity>> {
        return taskDao.getAllTasks()
    }

    suspend fun insertTask(task: TaskEntity) {
        taskDao.insertTask(task)
    }

    suspend fun updateTask(task: TaskEntity) {
        taskDao.updateTask(task)
    }

    suspend fun deleteTask(task: TaskEntity) {
        taskDao.deleteTask(task)
    }

    suspend fun getTaskById(id: Int): TaskEntity? {
        return taskDao.getTaskById(id)
    }
}
