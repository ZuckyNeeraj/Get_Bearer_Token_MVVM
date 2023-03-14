package com.example.getbearertokenfromapi.viewModel

import androidx.lifecycle.ViewModel
import com.example.getbearertokenfromapi.model.TokenRequest
import com.example.getbearertokenfromapi.model.TokenResponse
import com.example.getbearertokenfromapi.repository.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class viewModel : ViewModel() {

    private lateinit var itemRepository: ItemRepository

    /**
     * This function will get the access token by making a request to the API.
     * @param clientName the name of the client
     * @param clientEmail the email of the client
     * @return the access token
     */
    suspend fun getAccessToken(clientName: String, clientEmail: String): String {
        val tokenRequest = TokenRequest(clientName, clientEmail)

        return withContext(Dispatchers.IO) {
            try {
                itemRepository = ItemRepository(tokenRequest)
                val response: TokenResponse = itemRepository.getItems()
                response.accessToken
            } catch (e: Exception) {
                throw e
            }
        }
    }

}
