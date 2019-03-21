package com.man.sport.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 19, March, 2019
 */
@Entity(tableName = "team")
data class TeamDetail(
    @PrimaryKey(autoGenerate = true)
    var mId: Int,
    @ColumnInfo(name = "team_name")
    @SerializedName("strTeam")
    var teamName: String,
    @ColumnInfo(name = "team_logo")
    @SerializedName("strTeamBadge")
    var teamLogo: String
)