package com.example.fourrwallsrsbtestapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fourrwallsrsbtestapp.adapters.UsersRVAdapter
import com.example.fourrwallsrsbtestapp.callbacks.UsersRVCallback
import com.example.fourrwallsrsbtestapp.data.UsersData
import com.example.fourrwallsrsbtestapp.data.model.UsersViewModel
import com.example.fourrwallsrsbtestapp.data.model.UsersViewModelFactory
import com.example.fourrwallsrsbtestapp.data.repositories.UserRepository
import com.example.fourrwallsrsbtestapp.network.PostApi
import kotlinx.android.synthetic.main.fragment_users.*

class UsersFragment : Fragment(), UsersRVCallback {

    private lateinit var viewModel: UsersViewModel
    private lateinit var factory: UsersViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = PostApi()
        val repository = UserRepository(api)
        factory = UsersViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(UsersViewModel::class.java)
        viewModel.getUsers()
        viewModel.users.observe(viewLifecycleOwner, Observer { users ->
            rv_users.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = UsersRVAdapter(users, this)
            }

        })

    }

    override fun rvItemClickCallback(view: View, users: UsersData) {
        TODO("Not yet implemented")
    }
}