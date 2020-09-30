@file:Suppress("UNCHECKED_CAST")

package com.srkpindia.coroutine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


private lateinit var modelList: List<ExamModel>

class CoroutineActivity : AppCompatActivity() {
    private var apiClient = ApiClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

           // apiClient=DaggerApplicationComponent.create().getApi()

            recycler_main.setHasFixedSize(true)
            recycler_main.layoutManager = GridLayoutManager(this, 2)

            GlobalScope.launch(Dispatchers.IO) {
                val response =apiClient.getClient().GetExamList("EXAM_LIST", "13")
                if (response?.isSuccessful!!){
                    modelList= (response.body() as List<ExamModel>?)!!
                    showUI(modelList)
                }
            }
    }


     private suspend fun showUI(model: List<ExamModel>){
        withContext(Dispatchers.Main){
            val verticalData = CustomExamList(this@CoroutineActivity, model)
            recycler_main.adapter = verticalData
            verticalData.notifyDataSetChanged()
        }
    }
}