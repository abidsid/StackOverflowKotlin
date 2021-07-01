package com.example.stackoverflowkotlin.data.remote.response

data class Question(
    val accepted_answer_id: Long? = 0L,
    val answer_count: Int? = 0,
    val closed_date: Long? = 0L,
    val closed_reason: String? = "",
    val content_license: String? = "",
    val creation_date: Long? = 0L,
    val is_answered: Boolean? = true,
    val last_activity_date: Long? = 0L,
    val last_edit_date: Long? = 0L,
    val link: String?,
    val owner: Owner?,
    val question_id: Long? = 0L,
    val score: Int? = 0,
    val tags: List<String>? = emptyList(),
    val title: String? = "",
    val view_count: Int? = 0
)
