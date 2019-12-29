package com.example.shotteru

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.player_category_layout.view.*

class PlayerAndCategoryAdapter(context: Context, private val playersAndCategories: ArrayList<PlayerOrCategoryModel>, val clickListener: (PlayerOrCategoryModel, Int) -> Unit) :
    RecyclerView.Adapter<PlayerAndCategoryAdapter.ViewHolder>() {

    private val mContext: Context = context

    override fun getItemCount(): Int {
        return playersAndCategories.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        return  ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.player_category_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = playersAndCategories[position]
        holder.playerOrCategoryString.setText(model.playerOrCategoryString)
        holder.itemView.setOnClickListener{clickListener(model, position)}
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val playerOrCategoryString = view.playerOrCategoryEditText!!
    }

}

