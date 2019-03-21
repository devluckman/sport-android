package com.man.sport.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.man.sport.model.TeamDetail

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */
@Database(entities = [TeamDetail::class], version = 1)
abstract class TeamDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: TeamDatabase? = null

        fun getInstance(context: Context): TeamDatabase? {
            if (INSTANCE == null) {
                synchronized(TeamDatabase::class) {
                    INSTANCE =
                        Room.databaseBuilder(context.applicationContext, TeamDatabase::class.java, "Team.db").build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

    abstract fun teamDao(): TeamDao

}