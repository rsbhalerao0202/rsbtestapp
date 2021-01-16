package com.example.fourrwallsrsbtestapp.data.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fourrwallsrsbtestapp.coroutines.Coroutines
import com.example.fourrwallsrsbtestapp.data.UsersData
import com.example.fourrwallsrsbtestapp.data.repositories.UserRepository
import kotlinx.coroutines.Job

class UsersViewModel( private val repository: UserRepository): ViewModel() {
    private val _users = MutableLiveData<List<UsersData>>()

    private lateinit var job: Job

    val users : MutableLiveData<List<UsersData>>
        get() = _users

    fun getUsers(){
        job = Coroutines.ioMain(
            {repository.getUsers()},
            {_users.value = it}
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}