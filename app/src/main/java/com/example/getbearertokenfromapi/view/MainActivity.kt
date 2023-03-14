package com.example.getbearertokenfromapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.getbearertokenfromapi.databinding.ActivityMainBinding
import com.example.getbearertokenfromapi.viewModel.viewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: viewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onSubmitClick()
    }

    /**
     * This function will trigger on clicking of submit button.
     * It will print token on successful request.
     * @return null
     */
    private fun onSubmitClick() {
        binding.buttonSubmit.setOnClickListener {
            val clientName = binding.editTextClientName.text.toString()
            val clientEmail = binding.editTextClientEmail.text.toString()

            CoroutineScope(Dispatchers.Main).launch {
                try {
                    val token = viewModel.getAccessToken(clientName, clientEmail)
                    Log.d("response", token)
                } catch (e: Exception) {
                    Log.e("error", "There is some errors $e")
                }
            }
        }
    }


}
