package com.man.sport.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.man.sport.model.TeamDetail

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */
@Dao
interface TeamDao {

    @Query("SELECT * FROM team")
    fun getTeams(): MutableList<TeamDetail>

    @Insert
    fun insertTeam(team: MutableList<TeamDetail>)
}