package com.artem.noteskotlin.model

data class FakeNote (

    val id: Long,
    val name: String,
    val date : String,
    val description : List<String>,
    val image:String,
    val done_state: Boolean=false,


)