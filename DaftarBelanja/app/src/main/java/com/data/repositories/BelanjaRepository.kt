package com.data.repositories

import com.data.db.entities.BarangBelanja
import com.data.db.BelanjaDatabase

class BelanjaRepository (
    private val db: BelanjaDatabase
){
  suspend fun upsert(item: BarangBelanja) = db.getBelanjaDao().upsert(item)
    suspend fun delete(item: BarangBelanja) = db.getBelanjaDao().delete(item)
    fun getAllBarangBelanja() = db.getBelanjaDao().getSemuaBarangBelanja()
}