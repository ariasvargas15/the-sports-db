package com.brayanarias.thesportsdb.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.brayanarias.thesportsdb.GetTeamsByLeague
import com.brayanarias.thesportsdb.R
import com.brayanarias.thesportsdb.domain.Team
import com.brayanarias.thesportsdb.presentation.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TeamAdapter
    private val viewModel: MainViewModel by viewModels()


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

    private fun updateUi(uiModel: MainViewModel.UiModel) {
        progress.visibility = if (uiModel is MainViewModel.UiModel.Loading) View.VISIBLE else View.GONE
        when(uiModel){
            is MainViewModel.UiModel.Content -> {
                adapter.teams = uiModel.teams
                adapter.notifyDataSetChanged()
            }
            is MainViewModel.UiModel.Navigation -> {
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.TEAM, uiModel.team)
                }
                startActivity(intent)
            }

        }
    }

}