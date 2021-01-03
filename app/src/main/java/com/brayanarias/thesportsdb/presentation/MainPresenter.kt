package com.brayanarias.thesportsdb.presentation

import android.view.View
import com.brayanarias.thesportsdb.GetTeamsByLeague
import com.brayanarias.thesportsdb.domain.Team
import com.brayanarias.thesportsdb.presentation.commons.ScopeImpl
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Scope

class MainPresenter constructor(private val getTeamsByLeague: GetTeamsByLeague, private val view: IMain.View): IMain.Presenter,
    ScopeImpl() {


    override fun getList(nameLeague: String) {
        launch {
            view.showList(getTeamsByLeague.invoke(nameLeague))
        }
    }
}