package com.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.data.db.entities.BarangBelanja
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(
    entities = [BarangBelanja::class],
    version = 1
)
abstract class BelanjaDatabase: RoomDatabase() {
    abstract fun getBelanjaDao(): BelanjaDao

    companion object {
        @Volatile
        private var instance: BelanjaDatabase? = null
        private val LOCK = Any()

        @InternalCoroutinesApi
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buatDatabase(context).also { instance = it }
        }

        private fun buatDatabase(context: Context) =
        Room.databaseBuilder(context.applicationContext,
        BelanjaDatabase::class.java, "BelanjaDB.com.data.db").build()
    }
}