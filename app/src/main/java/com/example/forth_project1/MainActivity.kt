package com.example.forth_project1

import android.content.ClipData.Item
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.forth_project1.databinding.ActivityMainBinding


lateinit var binding: ActivityMainBinding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        val books = mutableListOf<Book>(
            Book(R.drawable.blood,"Bloodling","by James Rollins",4.5f),
            Book(R.drawable.humming,"The Humming","by Luis Alberto",4.5f),
            Book(R.drawable.nostra,"Tera Nostra","by carlos Fuentes",4.5f),
            Book(R.drawable.angels,"Angels & Demons","by Dan Brown",4.5f),
            Book(R.drawable.spirits,"Inforno","by Dan Brown",4.5f),
            Book(R.drawable.solitude,"One Hundred Years of Solitude","by Gabriel Garcia",4.5f),
            Book(R.drawable.sword,"The Sword Thief","by Peter",4.5f),
        )

        val bookAdapter =BookAdapter(books)
        binding.recycleView.adapter=bookAdapter



        binding.toolbar.topAppBar.setNavigationOnClickListener {
            binding.drawerlayout.open()
        }

        binding.toolbar.topAppBar.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.notification ->{
                    Toast.makeText(this,R.string.notificationClick,Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        binding.navigationview.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_star -> {
                    Toast.makeText(this,R.string.reviewsClick,Toast.LENGTH_SHORT).show()
                    binding.drawerlayout.close()
                    true
                }
                R.id.nav_favorite -> {
                    Toast.makeText(this,R.string.favoriteClick,Toast.LENGTH_SHORT).show()
                    binding.drawerlayout.close()
                    true
                }
                R.id.nav_search -> {
                    Toast.makeText(this,R.string.searchClick,Toast.LENGTH_SHORT).show()
                    binding.drawerlayout.close()
                    true
                }
                R.id.nav_profile -> {
                    Toast.makeText(this,R.string.profileClick,Toast.LENGTH_SHORT).show()
                    binding.drawerlayout.close()
                    true
                }
                R.id.nav_setting -> {
                    Toast.makeText(this,R.string.settingClick,Toast.LENGTH_SHORT).show()
                    binding.drawerlayout.close()
                    true
                }
                else -> false
            }
        }



    }
}