package com.example.cybeleminigames.userprofile

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserBase(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, "user.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableStatement: String = "CREATE TABLE USER_TABLE (USERNAME TEXT)"
        db?.execSQL(createTableStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}