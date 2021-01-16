package com.example.fourrwallsrsbtestapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.fourrwallsrsbtestapp.data.repositories.PostRepository
import com.example.fourrwallsrsbtestapp.network.PostApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(Color.WHITE);

        navController = Navigation.findNavController(this, R.id.fragment)

        NavigationUI.setupWithNavController(nav_view, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.exitFragment) {
                toolbar.visibility = View.GONE
//                bottomNavigationView.visibility = View.GONE
            } else {
                toolbar.visibility = View.VISIBLE
//                bottomNavigationView.visibility = View.VISIBLE
            }
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawer_layout)
    }
}
