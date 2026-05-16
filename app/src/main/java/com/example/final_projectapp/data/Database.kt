package com.example.final_projectapp.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context) :
    SQLiteOpenHelper(context, "Users.db", null, 2) {

    override fun onCreate(db: SQLiteDatabase?) {

        // users table
        db?.execSQL(
            "CREATE TABLE users(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "username TEXT," +
                    "password TEXT)"
        )

        // tasks table
        db?.execSQL(
            "CREATE TABLE tasks(" +
                    "task_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "task_title TEXT)"
        )
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {

        db?.execSQL("DROP TABLE IF EXISTS users")

        db?.execSQL("DROP TABLE IF EXISTS tasks")

        onCreate(db)
    }

    // ================= USERS =================

    fun insertUser(
        username: String,
        password: String
    ): Boolean {

        val db = writableDatabase

        val values = ContentValues()

        values.put("username", username)
        values.put("password", password)

        val result = db.insert("users", null, values)

        return result != -1L
    }

    fun checkUser(
        username: String,
        password: String
    ): Boolean {

        val db = readableDatabase

        val query =
            "SELECT * FROM users WHERE username=? AND password=?"

        val cursor = db.rawQuery(
            query,
            arrayOf(username, password)
        )

        val result = cursor.count > 0

        cursor.close()

        return result
    }

    // ================= TASKS =================

    fun insertTask(taskTitle: String): Boolean {

        val db = writableDatabase

        val values = ContentValues()

        values.put("task_title", taskTitle)

        val result = db.insert(
            "tasks",
            null,
            values
        )

        return result != -1L
    }

    fun getAllTasks(): ArrayList<String> {

        val taskList = ArrayList<String>()

        val db = readableDatabase

        val cursor =
            db.rawQuery(
                "SELECT * FROM tasks",
                null
            )

        while (cursor.moveToNext()) {

            val title = cursor.getString(1)

            taskList.add(title)
        }

        cursor.close()

        return taskList
    }

    fun deleteAllTasks() {

        val db = writableDatabase

        db.execSQL("DELETE FROM tasks")
    }
}