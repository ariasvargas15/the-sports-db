package com.brayanarias.thesportsdb.presentation.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.brayanarias.thesportsdb.R
import com.brayanarias.thesportsdb.domain.Team
import com.brayanarias.thesportsdb.presentation.main.TeamAdapter
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_detail.*

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    companion object {
        const val TEAM = "DetailActivity:team"
    }
    private lateinit var adapter: EventAdapter
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        adapter = EventAdapter()
        recycler.adapter = adapter
        viewModel.team = intent.getSerializableExtra(DetailActivity.TEAM) as Team
        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(uiModel: DetailViewModel.UiModel) {
        adapter.events = uiModel.events
        adapter.notifyDataSetChanged()
        if(uiModel.events.isEmpty()) eventsTitle.visibility = View.GONE
        teamName.text = uiModel.team.name
        description.text = uiModel.team.description
        val foundation = "Foundation year: " + uiModel.team.foundationYear
        foundationYear.text = foundation
        if (uiModel.team.badge.startsWith("http", true)) {
            Glide.with(this).load(uiModel.team.badge).into(badgeImage)
        }
        if (uiModel.team.jersey.startsWith("http", true)) {
            Glide.with(this).load(uiModel.team.jersey).into(jerseyImage)
        }
        if (uiModel.team.website.isEmpty()) {
            website.visibility = View.GONE
        }
        if (uiModel.team.facebook.isEmpty()) {
            facebook.visibility = View.GONE
        }
        if (uiModel.team.instagram.isEmpty()) {
            instagram.visibility = View.GONE
        }
        if (uiModel.team.twitter.isEmpty()) {
            twitter.visibility = View.GONE
        }
        if (uiModel.team.youtube.isEmpty()) {
            youtube.visibility = View.GONE
        }

    }

    private fun openLink(link: String) {
        var url = link
        if (!link.contains("http", true)) {
            url = "http://$link"
        }
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)

    }

    fun openWebsite(view: View) = openLink(viewModel.team.website)
    fun openFacebook(view: View) = openLink(viewModel.team.facebook)
    fun openInstagram(view: View) = openLink(viewModel.team.instagram)
    fun openTwitter(view: View) = openLink(viewModel.team.twitter)
    fun openYoutube(view: View) = openLink(viewModel.team.youtube)
}