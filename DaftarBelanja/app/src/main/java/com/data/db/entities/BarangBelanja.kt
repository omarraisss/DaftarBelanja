package com.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "barang_belanja")
data class BarangBelanja (
    @ColumnInfo(name = "nama_barang")
    var nama: String,
    @ColumnInfo(name = "jumlah_barang")
    var jumlah: Int
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}