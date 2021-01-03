package com.brayanarias.thesportsdb.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.brayanarias.thesportsdb.R
import com.brayanarias.thesportsdb.presentation.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class ListTeamsActivity : AppCompatActivity() {

    private lateinit var adapter: TeamAdapter
    private val viewModel: ListTeamsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val league = "League: Spanish La Liga"
        title_league.text = league
        adapter = TeamAdapter(viewModel::onMovieClicked)
        recycler.adapter = adapter
        viewModel.leagueName = "Spanish La Liga"
        viewModel.model.observe(this, Observer(::updateUi))

    }

    private fun updateUi(uiModel: ListTeamsViewModel.UiModel) {
        progress.visibility = if (uiModel is ListTeamsViewModel.UiModel.Loading) View.VISIBLE else View.GONE
        when(uiModel){
            is ListTeamsViewModel.UiModel.Content -> {
                adapter.teams = uiModel.teams
                adapter.notifyDataSetChanged()
            }
            is ListTeamsViewModel.UiModel.Navigation -> {
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.TEAM, uiModel.team)
                }
                startActivity(intent)
            }

        }
    }

}