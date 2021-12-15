package com.example.convidados.service.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.convidados.service.constants.DataBaseConstants

class GuestDataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    // Essa função é acionada quando você acessa pela primeira vez a classe GuestDataBaseHelper e você ainda não tem um banco.
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_GUEST)
    }

    // Essa função é acionada quando você já tem um banco e ela atualiza
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Convidados.db"

        private const val CREATE_TABLE_GUEST =
            ("create table "
                + DataBaseConstants.GUEST.TABLE_NAME + " ( "
                + DataBaseConstants.GUEST.COLUMNS.ID + " INTEGER PRIMARY KEY, "
                + DataBaseConstants.GUEST.COLUMNS.NAME + " text, "
                + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " integer);"
            )

    }

}