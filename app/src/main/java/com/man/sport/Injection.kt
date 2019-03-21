package com.man.sport

import android.content.Context
import com.man.sport.data.TeamRepository
import com.man.sport.data.local.TeamLocalDataSource
import com.man.sport.data.remote.TeamRemoteDataSource

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */
class Injection {
    /*
        Kelas Injection ini berfungsi sebagai kelas yang menyediakan resource
        dari kelas Repository
    */
    companion object {
        fun provideTeamRepository(context: Context): TeamRepository {
            return TeamRepository(TeamRemoteDataSource(), TeamLocalDataSource(context))
        }
    }
}