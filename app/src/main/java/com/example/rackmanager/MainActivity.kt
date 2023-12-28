package com.example.rackmanager

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class MainActivity:AppCompatActivity() {

    private val apiService = RetrofitClient.apiService
    private val rackRepository = RackRepository(apiService)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().isAutoInitEnabled = true

        val tvList = findViewById<TextView>(R.id.tvList)
        val cbMGU = findViewById<CheckBox>(R.id.cbMGU)
        val cbIdc = findViewById<CheckBox>(R.id.cbIdc)
        val cbEvo = findViewById<CheckBox>(R.id.Evo)
        val submitButton = findViewById<Button>(R.id.Submit)

        submitButton.setOnClickListener {
            lifecycleScope.launch {
                // val id = "1"

                val selectedRacks = mutableListOf<String>()

                if (cbMGU.isChecked) {
                    selectedRacks.add("MGU")
                    Log.d("FirstActivity", "User selected MGU")
                }

                if (cbIdc.isChecked) {
                    selectedRacks.add("IDC23")
                    Log.d("FirstActivity", "User selected IDC23")
                }

                if (cbEvo.isChecked) {
                    selectedRacks.add("IDC Evo")
                    Log.d("FirstActivity", "User selected IDC Evo")
                }

                val message = if (selectedRacks.isNotEmpty()) {
                    "Selected Racks: ${selectedRacks.joinToString(", ")}"
                } else {
                    "No racks selected."
                }

                tvList.text = message

                for (rackName in selectedRacks) {

                    try {
                        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
                        val rackEntity = RackEntity(name = rackName, date = dateFormat.format(Date()) )
                        rackRepository.createRack(rackEntity)
                    } catch (e: Exception) {
                        Log.e("MainActivity", "Error creating rack: ${e.message}", e)
                    }
                }
            }

        }
    }
}

