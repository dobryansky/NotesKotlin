package com.artem.noteskotlin.model

import android.app.Application

class App:Application() {
    val fakeList=FakeNoteService()
}