package com.daftarbelanja

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.data.repositories.BelanjaRepository

@Suppress("UNCHECKED_CAST")
class BelanjaViewModelFactory(
    private val repository: BelanjaRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BelanjaViewModel(repository) as T
    }
}