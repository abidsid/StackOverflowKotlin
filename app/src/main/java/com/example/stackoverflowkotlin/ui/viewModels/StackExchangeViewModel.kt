package com.example.stackoverflowkotlin.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.stackoverflowkotlin.data.remote.repository.StackExchangeRepository
import com.example.stackoverflowkotlin.data.remote.response.Question

class StackExchangeViewModel : ViewModel() {

    private val stackExchangeRepository = StackExchangeRepository()

    fun getQuestionsList(): LiveData<List<Question>> = stackExchangeRepository.getQuestionsList()

}