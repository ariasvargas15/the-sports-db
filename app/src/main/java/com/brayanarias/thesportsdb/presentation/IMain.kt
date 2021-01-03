package com.brayanarias.thesportsdb.presentation

import com.brayanarias.thesportsdb.domain.Team

interface IMain {
    interface View {
        fun showList(teams: List<Team>)
        fun doSomething()
    }

    interface Presenter {
        fun getList(nameLeague: String)
    }
}