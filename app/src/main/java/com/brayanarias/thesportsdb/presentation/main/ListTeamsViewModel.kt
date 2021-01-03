package com.brayanarias.thesportsdb.presentation.main

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.brayanarias.thesportsdb.GetTeamsByLeague
import com.brayanarias.thesportsdb.domain.Team
import com.brayanarias.thesportsdb.presentation.commons.ScopedViewModel
import kotlinx.coroutines.launch

class ListTeamsViewModel @ViewModelInject constructor(
    private val getTeamsByLeague: GetTeamsByLeague,
) : ScopedViewModel() {

    lateinit var leagueName: String

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) listTeams()
            Log.e("error", _model.value.toString())
            return _model
        }

    sealed class UiModel() {
        object Loading : UiModel()
        class Content(val teams: List<Team>) : UiModel()
        class Navigation(val team: Team) : UiModel()
    }

    init {
        initScope()
    }

    private fun listTeams() {
        launch {
            _model.value = UiModel.Loading
            val list = getTeamsByLeague.invoke(leagueName)
            _model.value = UiModel.Content(list)
            Log.e("eeo", list.toString())
        }
    }

    fun onMovieClicked(team: Team) {
        _model.value = UiModel.Navigation(team)
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}