package com.man.sport.view

import com.man.sport.model.TeamDetail

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */
interface TeamNavigator {
    fun loadListTeam(listTeam: MutableList<TeamDetail>)
    fun errorLoadTeam(message: String)
}