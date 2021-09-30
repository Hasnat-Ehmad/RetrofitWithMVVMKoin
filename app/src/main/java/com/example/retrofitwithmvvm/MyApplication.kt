package com.example.retrofitwithmvvm

import android.app.Application
import android.content.Context
import android.os.StrictMode
import com.example.retrofitwithmvvm.util.UtilsDependency
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build()
        )

        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build()
        )

        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(networkModule, /*mainRepoModule,*/ viewModelModule, UtilsDependency))
        }
    }
}