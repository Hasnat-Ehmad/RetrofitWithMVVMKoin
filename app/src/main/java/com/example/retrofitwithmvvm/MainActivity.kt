package com.example.retrofitwithmvvm

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithmvvm.core.BaseActivity
import com.example.retrofitwithmvvm.util.Status
import com.example.retrofitwithmvvm.util.Utils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.coroutines.CoroutineContext


class MainActivity : BaseActivity(),CoroutineScope {

    //Inject use case using Koin
    private lateinit var job: Job

    //private lateinit var progressBar: ProgressBar
    //private lateinit var recyclerView: RecyclerView

    private val handler = CoroutineExceptionHandler { _, exception ->
        Log.d(TAG, "$exception handled !")
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job + handler



    //private val mainViewModel: MainViewModel by viewModel()
    //lateinit var viewModel: MainViewModel
    //private val viewModel:MainViewModel by viewModel<MainViewModel>()
    //View model injection using Koin way
    private val viewModel by viewModel<MainViewModel>()
    //private val retrofitService: RetrofitService by inject()
    //private val repository:MainRepository by inject()
    val adapter = MainAdapter()

    val TAG = "Main Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        job = Job()

        initView()
        setupViewModel()
        setupObserverBookList()

//        GlobalScope.async {
//            val deferred = viewModel.getAllMovies(
//                "a",
//                "a"
//            )
//
//            try {
//                val list = deferred
//            }catch (e:Exception){
//
//            }
//        }



        launch {
            supervisorScope {
                try {
                    withContext(Dispatchers.IO) {
                        viewModel.fetchBookList(
                            "a",
                            "a",
                            BuildConfig.API_KEY
                        )
                    }
                }catch (e:Exception){
                    Log.e("Exception",e.toString())
                }
            }

        }



    }

    private fun setupObserverBookList(){

        viewModel.getBookList().observe(this, {
            when(it.status){
                Status.LOADING -> {
                    Log.e("Status","Loading")
                    progressBar.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    Log.d(TAG, "onCreate: $it")
                    progressBar.visibility = View.GONE
                    it.data?.let { it1 -> adapter.setMovieList(it1) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    progressBar.visibility = View.GONE
                }
            }
        })
    }

    private fun initView() {
        //recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = adapter


        //progressBar = findViewById(R.id.progressBar)

    }

    private fun setupViewModel(){
        /*viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(
                ApiHelperImpl(provideApiService(get())),
                this@MainActivity.application
                //DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
            )
        ).get(MainViewModel::class.java)*/
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
        cancel()
    }
}