package com.example.retrofitwithmvvm.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import okhttp3.Cache
import org.koin.dsl.module


val UtilsDependency = module {

    factory {

        Utils()
    }

    //NOTE:
    // If repository is required to be passed over, while creating dependency itself Koin will support
}
class Utils {

        fun hasNetwork(context: Context): Boolean? {
            var isConnected: Boolean? = false // Initial Value
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
            if (activeNetwork != null && activeNetwork.isConnected)
                isConnected = true
            return isConnected
        }



}