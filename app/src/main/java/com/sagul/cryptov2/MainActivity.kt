package com.sagul.cryptov2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.sagul.cryptov2.databinding.ActivityMainBinding
import com.sagul.cryptov2.service.CryptoModel
import com.sagul.cryptov2.service.Retrofitz
import com.sagul.cryptov2.service.recyclerAdapter
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var listemu=ArrayList<CryptoModel>()
    private var adapter:recyclerAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var get:Retrofitz= Retrofitz()
        var exceptionHandler= CoroutineExceptionHandler{coroutineContext, throwable ->
            Toast.makeText(this,throwable.localizedMessage+"a",Toast.LENGTH_LONG).show()
        }

       CoroutineScope(Dispatchers.IO+exceptionHandler).launch {
           var go= get.retrom.getValues()

           withContext(Dispatchers.Main) {

               if (go.isSuccessful) {

                   go.body().also {
                       adapter= recyclerAdapter(it!!)
                       binding.recyclerView.layoutManager=GridLayoutManager(this@MainActivity,2)
                       binding.recyclerView.adapter=adapter
                   }
               }
           }
        }









    }


}