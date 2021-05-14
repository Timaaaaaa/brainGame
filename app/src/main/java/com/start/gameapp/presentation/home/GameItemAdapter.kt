package com.start.gameapp.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.start.gameapp.R
import com.start.gameapp.model.GameItem
import kotlinx.android.synthetic.main.i_general_game.view.*

class GameItemAdapter(
    private var items : List<GameItem>,
    private val action: (id : Int) -> Unit
) : RecyclerView.Adapter<GameItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.i_general_game, parent, false)
        return GameItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: GameItemViewHolder, position: Int) {
        holder.itemView.txt_nickname_item.setText(items[position].userName)
        holder.itemView.txt_status_item.setText(items[position].gameStatus)
    }

    fun setData(itemss : List<GameItem>){
        items = itemss
        notifyDataSetChanged()
    }
}

class GameItemViewHolder(val view: View) : RecyclerView.ViewHolder(view)