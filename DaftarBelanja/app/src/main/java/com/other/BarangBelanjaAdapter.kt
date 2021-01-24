package com.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarbelanja.R
import com.daftarbelanja.BelanjaViewModel
import com.data.db.entities.BarangBelanja
import kotlinx.android.synthetic.main.barang_belanja.view.*

class BarangBelanjaAdapter (
    var items: List<BarangBelanja>,
    private val viewModel: BelanjaViewModel
    ): RecyclerView.Adapter<BarangBelanjaAdapter.BelanjaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BelanjaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.barang_belanja, parent, false)
        return BelanjaViewHolder(view)
    }

    override fun onBindViewHolder(holder: BelanjaViewHolder, position: Int) {
        val curBarangBelanja = items[position]

        holder.itemView.tvNama.text = curBarangBelanja.nama
        holder.itemView.tvJumlah.text = "${curBarangBelanja.jumlah}"

        holder.itemView.ivHapus.setOnClickListener {
            viewModel.delete(curBarangBelanja)
        }

        holder.itemView.ivPlus.setOnClickListener {
            curBarangBelanja.jumlah++
            viewModel.upsert(curBarangBelanja)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if(curBarangBelanja.jumlah > 0){
                curBarangBelanja.jumlah--
                viewModel.upsert(curBarangBelanja)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class BelanjaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}