package com.brayanarias.thesportsdb.presentation.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.brayanarias.thesportsdb.GetEventsByTeam
import com.brayanarias.thesportsdb.domain.Event
import com.brayanarias.thesportsdb.domain.Team
import com.brayanarias.thesportsdb.presentation.commons.ScopedViewModel
import kotlinx.coroutines.launch

class DetailViewModel @ViewModelInject constructor(
    private val getEventsByTeam: GetEventsByTeam
) : ScopedViewModel() {

    lateinit var team: Team

    class UiModel(val team: Team, val events: List<Event>)

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) loadTeam()
            return _model
        }

    private fun loadTeam() = launch {
        _model.value = UiModel(team, getEventsByTeam.invoke(team.id))
    }
}