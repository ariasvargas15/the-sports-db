package com.brayanarias.thesportsdb.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.brayanarias.thesportsdb.GetTeamsByLeague
import com.brayanarias.thesportsdb.R
import com.brayanarias.thesportsdb.domain.Team
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), IMain.View {

    private lateinit var adapter: TeamAdapter
    lateinit var presenter: IMain.Presenter
    @Inject lateinit var getTeamsByLeague: GetTeamsByLeague

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val league = "League: Spanish La Liga"
        title_league.text = league
        presenter = MainPresenter(getTeamsByLeague, this)
        presenter.getList("Spanish La Liga")
        progress.visibility = View.VISIBLE
    }

    override fun showList(teams: List<Team>) {
        adapter = TeamAdapter { doSomething() }
        adapter.teams = teams
        recycler.adapter = adapter
        progress.visibility = View.GONE
    }

    override fun doSomething() {
        TODO("Not yet implemented")
    }
}