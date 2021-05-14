package com.start.gameapp.base

import android.app.Application
import android.content.Context
import com.start.gameapp.di.networkModule
import com.start.gameapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.lang.System.setProperty

class GameApp : Application() {

    var context  : Context? = null

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin {
            androidContext(this@GameApp)
            modules(
                listOf(
                        networkModule,
                        viewModelModule
                )
            )
        }

        setProperty("staging_url", "http://staging.domain.com")
    }

}