package com.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.data.db.entities.BarangBelanja

@Dao
interface BelanjaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: BarangBelanja)
    @Delete
    suspend fun delete(item: BarangBelanja)
    @Query(value = "SELECT * FROM barang_belanja")
    fun getSemuaBarangBelanja(): LiveData<List<BarangBelanja>>
}