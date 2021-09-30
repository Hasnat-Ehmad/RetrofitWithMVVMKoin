package com.example.retrofitwithmvvm.core

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.retrofitwithmvvm.util.Utils
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.android.inject

/**
 * Base Fragment class.
 * Prepares View Model Factory as well for sub classes/Fragments.
 */
abstract class BaseActivity : AppCompatActivity(){

    //Injecting utility class for further usage
    val mAppUtility : Utils by inject()

}