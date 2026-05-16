# 📝 To Do List App (Android - Kotlin)

Simple To Do List mobile application built using **Kotlin + SQLite** in Android Studio.

---

## 🚀 Features

- User Registration (Sign Up)
- User Login Authentication
- Add Tasks
- Display Tasks in RecyclerView
- Save Tasks in SQLite Database
- Delete All Tasks Button
- Simple and clean UI

---

## 🛠️ Tech Stack

- Kotlin
- Android Studio
- SQLite Database
- RecyclerView
- XML Layouts

---

## 📱 App Flow

1. User signs up with username & password
2. User logs in
3. User enters To Do screen
4. Add tasks using input field
5. Tasks are saved in local database
6. Tasks are displayed in list
7. Option to delete all tasks

---

## 📂 Project Structure
com.example.final_projectapp
│
├── data
│ └── Database.kt
│
├── ui
│ ├── login.kt
│ └── MainActivity.kt (Register)
│
├── list_activity.kt
├── Task.kt
├── TaskAdapter.kt


---

## 🗄️ Database

Two tables are used:

### Users Table
- id (Primary Key)
- username
- password

### Tasks Table
- task_id (Primary Key)
- task_title

---

## 📸 Screens (Optional)

You can add screenshots here:
/screenshots/login.png
/screenshots/register.png
/screenshots/todo.png


---

## ▶️ How to Run

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle
4. Run on emulator or real device

---

## 💡 Future Improvements

- Delete single task
- Edit task
- Mark task as completed
- Firebase integration
- UI improvements (Material Design)

---

## 👨‍💻 Developer

- Android Student Project
- Built for learning purposes

---




