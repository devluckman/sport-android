package com.man.sport.viewmodel

import android.content.Context
import com.man.sport.data.TeamDataSource
import com.man.sport.data.TeamRepository
import com.man.sport.model.Team
import com.man.sport.view.TeamNavigator

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */
class HomeViewModel (val teamRepository: TeamRepository, context: Context) {
    private lateinit var teamNavigator: TeamNavigator

    fun setNavigator(teamNavigator: TeamNavigator) {
        this.teamNavigator = teamNavigator
    }

    fun getListTeam() {
        teamRepository.getListTeams(
            object : TeamDataSource.GetTeamsCallback {
                override fun onTeamLoaded(data: Team) {
                    teamNavigator.loadListTeam(data.teams)
                }

                override fun onDataNotAvailable(message: String) {
                    teamNavigator.errorLoadTeam(message)
                }

            }
        )
    }


}