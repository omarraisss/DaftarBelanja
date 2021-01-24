package com.daftarbelanja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daftarbelanja.R
import com.data.db.BelanjaDatabase
import com.data.db.entities.BarangBelanja
import com.data.repositories.BelanjaRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.InternalCoroutinesApi
import com.other.BarangBelanjaAdapter
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private val factory: BelanjaViewModelFactory by instance()

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this, factory).get(BelanjaViewModel::class.java)

        val adapter = BarangBelanjaAdapter(listOf(), viewModel)

        rvBarangBelanja.layoutManager = LinearLayoutManager(this)
        rvBarangBelanja.adapter = adapter

        viewModel.getAllBarangBelanja().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddBarangBelanjaDialog(this,
            object : AddDialogListener{
                override fun onAddButtonClicked(item: BarangBelanja) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}