package com.example.stackoverflowkotlin.ui.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.stackoverflowkotlin.R
import com.example.stackoverflowkotlin.databinding.ActivityMainBinding
import com.example.stackoverflowkotlin.ui.adapters.QuestionAdapter
import com.example.stackoverflowkotlin.ui.viewModels.StackExchangeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupTheme()
    }

    private fun setupTheme() {
        val factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        val viewModel = ViewModelProvider(this, factory).get(StackExchangeViewModel::class.java)

        val adapter = QuestionAdapter { openLink(it) }
        binding.recyclerView.adapter = adapter

        viewModel.getQuestionsList().observe(this, { questionsList ->
            questionsList?.let { adapter.updateList(it) }
        })
    }

    private fun openLink(link: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}