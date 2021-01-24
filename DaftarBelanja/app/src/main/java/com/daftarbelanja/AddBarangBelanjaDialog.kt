package com.daftarbelanja

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.daftarbelanja.R
import com.data.db.entities.BarangBelanja
import kotlinx.android.synthetic.main.dialog_add_barang_belanja.*

class AddBarangBelanjaDialog(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_barang_belanja)

        tvTambahkan.setOnClickListener {
            val nama = etNamaBarang.text.toString()
            val harga = etJumlah.text.toString()

            if (nama.isEmpty() || harga.isEmpty()) {
                Toast.makeText(context, "Dibutuhkan", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item = BarangBelanja(nama, harga.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        tvBatalkan.setOnClickListener {
            cancel()
        }
    }
}