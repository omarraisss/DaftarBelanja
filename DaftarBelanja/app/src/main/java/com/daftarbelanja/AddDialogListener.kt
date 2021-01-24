package com.daftarbelanja

import com.data.db.entities.BarangBelanja

interface AddDialogListener {
    fun onAddButtonClicked(item: BarangBelanja)
}