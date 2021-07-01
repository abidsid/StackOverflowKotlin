package com.example.stackoverflowkotlin.data.remote.response

data class Owner(
    val accept_rate: Int? = 0,
    val account_id: Int? = 0,
    val display_name: String? = "",
    val link: String? = "",
    val profile_image: String? = "",
    val reputation: Int? = 0,
    val user_id: Int? = 0,
    val user_type: String? = ""
)
