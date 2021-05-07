package com.example.contactbook.phonebook

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactbook.network.PhoneBookApi
import kotlinx.coroutines.launch

class PhoneBookViewModel : ViewModel() {
    private val token =
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImwyMDAxNDAwMDRAZ21haWwuY29tIiwicGFzc3dvcmQiOiIyNjJlZTQwMjcxYzdkZDMyM2EzZWNmNDIwMjg3ZjRhYyIsImlhdCI6MTYwNjcyNjg0NiwiZXhwIjoxNjA2ODEzMjQ2fQ.IMX8_G0beCWWdySB8ggNznR6y4xtEscPepIFQ5nqgLE"
    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status

    init {
        getPhoneContacts()
    }

    private fun getPhoneContacts() {
        viewModelScope.launch {
            val listResult = PhoneBookApi.retrofitService.getContacts(token)
            _status.value = listResult
        }
    }
}