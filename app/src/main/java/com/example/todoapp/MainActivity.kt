package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)

    }
    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.exit_dialog_title))
        builder.setMessage(getString(R.string.exit_dialog_message))
        builder.setPositiveButton(getString(R.string.option_yes)) { dialogInterface, _ ->
            dialogInterface.dismiss()
            super.onBackPressed()
        }
        builder.setNegativeButton(getString(R.string.option_no)) { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        builder.show()
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
