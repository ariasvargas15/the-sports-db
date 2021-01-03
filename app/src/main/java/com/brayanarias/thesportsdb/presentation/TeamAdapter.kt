package com.brayanarias.thesportsdb.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brayanarias.thesportsdb.R
import com.brayanarias.thesportsdb.domain.Team
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_team.view.*
import java.util.*

class TeamAdapter(private val listener: (Team) -> Unit) :
    RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    var teams: List<Team> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val team = teams[position]
        holder.bind(team)
        holder.itemView.setOnClickListener { listener(team) }
    }

    override fun getItemCount(): Int = teams.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(team: Team) {
            val name = "Equipo: " + team.name
            itemView.teamName.text = name
            val estadio = "Estadio: " + team.name
            itemView.teamStadium.text = team.stadium
            Glide.with(itemView.context).load(team.badge).into(itemView.image)
        }

    }


}