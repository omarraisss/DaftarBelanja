package com.daftarbelanja

import androidx.lifecycle.ViewModel
import com.data.db.entities.BarangBelanja
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.data.repositories.BelanjaRepository

class BelanjaViewModel(
    private val repository: BelanjaRepository
): ViewModel(){
    fun upsert(item: BarangBelanja) = CoroutineScope(Dispatchers.Main).launch {
     repository.upsert(item)}
    fun delete(item: BarangBelanja) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)}
    fun getAllBarangBelanja() = repository.getAllBarangBelanja()
}