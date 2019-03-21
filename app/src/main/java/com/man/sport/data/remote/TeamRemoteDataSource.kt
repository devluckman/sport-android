package com.man.sport.data.remote

import com.man.sport.data.TeamDataSource
import com.man.sport.model.Team
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */

/*
    kelas ini untuk mengkonfigurasi bagian pengambilan data dari internet/ API,

    Kelas ini akan meng implements ke dalam kelas interface
    TeamDataSource yang sebelumnya sudah kita buat, agar fungsi dan
    method - method dari kelas interface akan kita berikan body atau perintah
*/
class TeamRemoteDataSource : TeamDataSource, Callback<Team>{

    private val apiInterface = ApiClient.getClient().create(ApiInteface::class.java)
    private lateinit var callBack: TeamDataSource.GetTeamsCallback

    override fun getListTeams(getTeamsCallback: TeamDataSource.GetTeamsCallback) {
        callBack = getTeamsCallback
        val call = apiInterface.getAllTeams("English Premier League")
        call.enqueue(this)
    }

    override fun onResponse(call: Call<Team>, response: Response<Team>) {
        response.body()?.let { callBack.onTeamLoaded(it) }
    }

    override fun onFailure(call: Call<Team>, t: Throwable) {
        callBack.onDataNotAvailable(t.localizedMessage)
    }


}