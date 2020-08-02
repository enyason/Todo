package com.enyason.todo

import android.app.Application
import com.enyason.todo.di.AppContainer

class App : Application() {

    val appContainer = AppContainer(this)

}