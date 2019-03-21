package com.man.sport.data

import com.man.sport.model.Team

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */
interface TeamDataSource {

    /*
        interface ini berfungsi sebagai blue print kira - kira fungsi - fungsi
        atau method apa saja yang akan kita pakai dan juga seperti apa untuk
        callback nya, apa yang di inputkan dan apa yang akan dihasilkan
    */

    interface GetTeamsCallback {
        fun onTeamLoaded(data: Team)
        fun onDataNotAvailable(message: String)
    }

    fun getListTeams(getTeamsCallback: GetTeamsCallback)
}