package com.brayanarias.thesportsdb.presentation.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brayanarias.thesportsdb.R
import com.brayanarias.thesportsdb.domain.Event
import kotlinx.android.synthetic.main.item_event.view.*
import kotlinx.android.synthetic.main.item_team.view.*

class EventAdapter :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    var events: List<Event> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = events[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int = events.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(event: Event) {
            itemView.eventName.text = event.name
            val date = "Date: " + event.date.substring(0, 10)
            itemView.eventDate.text = date
            val time = "Time: " + event.date.substring(11, 16)
            itemView.eventTime.text = time

        }

    }


}