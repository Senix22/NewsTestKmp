package com.example.newstestkmp.android

import android.app.Application
import com.example.newstestkmp.android.di.dataBaseModule
import com.example.newstestkmp.android.di.viewModelModule
import com.example.newstestkmp.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin(){
        val modules = sharedKoinModule + viewModelModule + dataBaseModule
        startKoin {
            androidContext(this@App)
            modules(modules)
        }
    }
}