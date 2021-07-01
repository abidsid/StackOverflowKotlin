package com.example.stackoverflowkotlin.data.remote.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.stackoverflowkotlin.data.remote.api.ApiClient
import com.example.stackoverflowkotlin.data.remote.api.ApiInterface
import com.example.stackoverflowkotlin.data.remote.response.Question
import com.example.stackoverflowkotlin.data.remote.response.QuestionList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

private const val TAG = "Repo"

class StackExchangeRepository {

    private val _questionsList: ArrayList<Question> = ArrayList<Question>()
    private val questionsList: MutableLiveData<List<Question>> = MutableLiveData<List<Question>>()

    fun getQuestionsList(): MutableLiveData<List<Question>> {
        if (_questionsList.isEmpty()) loadQuestionsList()
        questionsList.value = _questionsList
        return questionsList
    }

    private fun loadQuestionsList() {
        val apiInterface = ApiClient.getRetrofit().create(ApiInterface::class.java)
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, -2)
        val call: Call<QuestionList> = apiInterface.getQuestionsList(
            calendar.timeInMillis / 1000,
            "desc",
            "activity",
            "True",
            2,
            "stackoverflow"
        )
        Log.d(TAG, "Response : " + call.request())
        Log.d(TAG, "Response : " + call.request().url())
        Log.d(TAG, "Response : " + call.request().toString())
        call.enqueue(object : Callback<QuestionList?> {
            override fun onResponse(call: Call<QuestionList?>, response: Response<QuestionList?>) {
                Log.d(TAG, "Response : " + response.raw())
                if (response.isSuccessful) {
                    _questionsList.clear()
                    response.body()?.let {
                        Log.d(TAG, "Response: " + it.items.size)
                        _questionsList.addAll(it.items)
                    }

                    Log.d(TAG, "Live Data " + _questionsList.size)
                    questionsList.postValue(_questionsList)
                }
            }

            override fun onFailure(call: Call<QuestionList?>, t: Throwable) {
                Log.d(TAG, "onFailure: " + t.message)
                t.printStackTrace()
            }
        })
    }


}