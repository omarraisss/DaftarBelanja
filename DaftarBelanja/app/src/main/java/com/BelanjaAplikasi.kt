package com

import android.app.Application
import com.daftarbelanja.BelanjaViewModelFactory
import com.data.db.BelanjaDatabase
import com.data.repositories.BelanjaRepository
import kotlinx.coroutines.InternalCoroutinesApi
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class BelanjaAplikasi: Application(), KodeinAware{
    @InternalCoroutinesApi
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@BelanjaAplikasi))
        bind() from singleton { BelanjaDatabase(instance()) }
        bind() from singleton { BelanjaRepository(instance()) }
        bind() from provider {
            BelanjaViewModelFactory(instance())
        }
    }
}