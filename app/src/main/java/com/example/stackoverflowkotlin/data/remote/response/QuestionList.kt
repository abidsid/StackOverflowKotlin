package com.example.stackoverflowkotlin.data.remote.response

data class QuestionList(
    val has_more: Boolean = false,
    val items: List<Question> = emptyList(),
    val quota_max: Int = 0,
    val quota_remaining: Int = 0
)
