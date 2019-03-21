package com.man.sport.data.remote

import com.man.sport.model.Team
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */
interface ApiInteface {
    @GET("api/v1/json/1/search_all_teams.php")
    fun getAllTeams(@Query("l") search: String): Call<Team>
}