package com.man.sport.data

import com.man.sport.data.local.TeamLocalDataSource
import com.man.sport.data.remote.TeamRemoteDataSource
import com.man.sport.model.Team

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */

/*
    kelas ini berfungsi untuk mempresentasikan fungsi dan method - method dari
    kelas remote dan kelas local
*/

class TeamRepository (
    private val teamRemoteDataSource: TeamRemoteDataSource,
    private val teamLocalDataSource: TeamLocalDataSource ) : TeamDataSource  {

    /*
        pada fungsi ini kita akan memanggil fungsi getListTeams dari kelas local
        (TeamLocalDataSource) jadi pertama kali aplikasi dibuka maka akan
        menampilkan data yang berada di database local ketika data kosong
        maka akan mengambil data dari API kemudian di simpan ke dalam
        database local (S)
    */

    override fun getListTeams(getTeamsCallback: TeamDataSource.GetTeamsCallback) {
        teamLocalDataSource.getListTeams(
            object : TeamDataSource.GetTeamsCallback{

                override fun onTeamLoaded(data: Team) {
                    getTeamsCallback.onTeamLoaded(data)
                }

                override fun onDataNotAvailable(message: String) {
                    getTeamsFromRemoteDataSource(getTeamsCallback)
                }

            }
        )
    }

    private fun getTeamsFromRemoteDataSource(callback: TeamDataSource.GetTeamsCallback?){
        teamRemoteDataSource.getListTeams(
            object : TeamDataSource.GetTeamsCallback{
                override fun onTeamLoaded(data: Team) {
                    teamLocalDataSource.saveDataTeam(data.teams)
                    callback?.onTeamLoaded(data)
                }

                override fun onDataNotAvailable(message: String) {
                    callback?.onDataNotAvailable(message)
                }

            }
        )
    }

    /*
        fungsi getTeamsFromRemote fungsi ini kita akan memanggil fungsi getListTeams dari kelas
        TeamRemoteDataSource, ketika data berhasil diambil dari API maka
        fungsi yang berada di dalam method callback onTeamLoaded akan
        dijalankan, di dalam method ini kita akan memanggil fungsi
        saveDataTeam yang berada pada kelas TeamLocalDataSource, fungsi ini
        untuk menyimpan data ke dalam database local (SQLite) jadi ketika data
        dari API berhasil diambil maka akan langsung disimpan ke dalam
        database local (SQLite)
    */

}