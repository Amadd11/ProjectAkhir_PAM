package com.example.projectakhir_pam

import android.app.Application
import com.example.projectakhir_pam.repository.ContainerApp
import com.example.projectakhir_pam.repository.ContainerDataApp

class HotelApp : Application(){
    /**
     * AppContainer instance digunakan oleh kelas-kelas lainnya untuk mendapatkan depedensi
     */
    lateinit var container : ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}