package com.example.shotteru

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.Nothing as Nothing1

class PlayerInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_input)
        playersOrCategoriesRecyclerView = findViewById(R.id.editPlayerOrCategoryRecyclerView)
        playersOrCategoriesRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter = PlayerAndCategoryAdapter(this, playersOrCategoriesList){playerOrCategoryObject: PlayerOrCategoryModel,position: Int ->
            Toast.makeText(this,playerOrCategoryObject.playerOrCategoryString, Toast.LENGTH_LONG).show()
        }
        playersOrCategoriesRecyclerView.adapter = adapter

        val addPlayerOrCategoryButton = findViewById<Button>(R.id.addPlayerOrCategoryButton)

        addPlayersTextData()

        addPlayerOrCategoryButton.setOnClickListener {
            Toast.makeText(this, playersOrCategoriesList[0].playerOrCategoryString, Toast.LENGTH_LONG).show()
            addPlayerOrCategoryText()
        }
    }

    companion object {
        lateinit var playersOrCategoriesRecyclerView: RecyclerView
        var playersOrCategoriesList = ArrayList<PlayerOrCategoryModel>()
        private var adapter: PlayerAndCategoryAdapter? = null
        private var playerOrCategoryIndexInt = 0
    }

    private fun addPlayerOrCategoryText() {
        playersOrCategoriesList.add(PlayerOrCategoryModel(playerOrCategoryIndexInt, ""))
        playerOrCategoryIndexInt++
        adapter!!.notifyDataSetChanged()
    }

    private fun removePlayerOrCategoryText() {
        playersOrCategoriesList.removeAt(1)
    }

    private fun addPlayersTextData() {
        playersOrCategoriesList.add(PlayerOrCategoryModel(playerOrCategoryIndexInt, ""))
        playerOrCategoryIndexInt++
        adapter!!.notifyDataSetChanged()
    }
}