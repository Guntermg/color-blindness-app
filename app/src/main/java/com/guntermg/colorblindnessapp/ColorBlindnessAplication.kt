package com.guntermg.colorblindnessapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ColorBlindnessAplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}