package com.man.sport.data.local

import android.content.Context
import com.man.sport.data.TeamDataSource
import com.man.sport.model.Team
import com.man.sport.model.TeamDetail

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */

/*
    Pada bagian method getListTeams kita menambahkan fungsi untuk
    mengambil data dari database local (SQLite), tapi sebelum nya kita akan
    melakukan pengecekan terlebih dahulu, apakah data dari database local
    (SQLite) tersedia

    Pada kelas ini juga kita akan buatkan fungsi untuk menyimpan data hasil
    dari pengambilan di internet ke dalam database local (SQLite), seperti
    terlihat pada gambar di bawah
*/
class TeamLocalDataSource (context: Context) : TeamDataSource {

    private var teamDao: TeamDao? = TeamDatabase.getInstance(context)?.teamDao()

    override fun getListTeams(getTeamsCallback: TeamDataSource.GetTeamsCallback) {
        Thread(
            Runnable {
                teamDao?.let {
                    if (it.getTeams().isEmpty()) {
                        getTeamsCallback.onDataNotAvailable("Data in DB Empty")

                    } else {
                        val teams = Team(it.getTeams())
                        getTeamsCallback.onTeamLoaded(teams)

                    }
                }
            }
        ).start()
    }


    fun saveDataTeam(team: MutableList<TeamDetail>) {
        Thread(
            Runnable {
                teamDao?.insertTeam(team)
            }
        ).start()
    }

}