package com.muhammadabdullah.bubblebookshelf

import android.app.Application
import android.util.Log
import com.amazonaws.mobile.client.AWSMobileClient
import com.muhammadabdullah.bubblebookshelf.database.AppDatabase

class BubbleBookShelfApplication : Application(){



    override fun onCreate() {
        super.onCreate()

        initializeAWS()
        initializeRoom()
        Log.i("Application:","Initialization Done")

    }


    fun initializeAWS(){
        AWSMobileClient.getInstance().initialize(this) {
            Log.d("Amazone", "AWSMobileClient is initialized")
        }.execute()
    }


    fun initializeRoom(){
        databaseInstace = AppDatabase.getDatabase(this)
    }


    companion object {
        lateinit var databaseInstace : AppDatabase
    }
}