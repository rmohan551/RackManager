/*

package com.example.rackmanager


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RackViewModelFactory(private val rackRepository: RackRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RackViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RackViewModel(rackRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
*/
