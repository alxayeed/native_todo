# ✅ Project Summary

Build a **To-Do List App** using **Kotlin**, **Room**, **MVVM**, **LiveData**, and **multiple screens** (activities). Along the way, you'll learn **data classes**, **sealed classes**, and **navigation between activities**.

---

## 🧠 Key Concepts to Learn

| Concept               | Details                                                           |
|-----------------------|-------------------------------------------------------------------|
| MVVM                 | Separation of concern: UI, Logic, and Data                        |
| Room DB              | Local persistence of tasks (add, delete, update, fetch)           |
| ViewModel            | Store and manage UI-related data                                  |
| LiveData             | Observe and react to data changes in UI                           |
| Multiple Activities  | Navigate between screens (e.g., Home → Add/Edit Task)             |
| Data Class           | Store simple structured data (like `TaskEntity`)                  |
| Sealed Class         | Represent UI states/events/errors cleanly                         |
| Intent Extras        | Pass data between activities                                      |
| RecyclerView + Adapter | Display list of to-do items                                     |

---

## 🗂️ App Features

| Feature                | Description                                                    |
|------------------------|----------------------------------------------------------------|
| Add Task              | Input screen to add a new task (title, optional description)   |
| View Task List        | Show all saved tasks using RecyclerView                        |
| Edit Task (Optional)  | Tap a task to edit it (same form as Add)                       |
| Delete Task           | Swipe or long press to delete                                  |
| Task Completion Toggle| Mark a task as completed/incomplete                            |

---

## 🏗️ Architecture Overview

<pre>
com.example.todoapp
├── data
│   ├── TaskEntity.kt
│   ├── TaskDao.kt
│   └── TaskDatabase.kt
├── repository
│   └── TaskRepository.kt
├── ui
│   ├── main
│   │   ├── MainActivity.kt
│   │   └── TaskAdapter.kt
│   └── addedit
│       └── AddEditTaskActivity.kt
├── viewmodel
│   └── TaskViewModel.kt
└── util
    └── UiState.kt (sealed class for loading/success/error states)
</pre>

---

✅ _Update this README after each phase to track the progress!_
