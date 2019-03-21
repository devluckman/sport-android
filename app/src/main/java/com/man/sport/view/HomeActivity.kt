package com.man.sport.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.man.sport.Injection
import com.man.sport.R
import com.man.sport.model.TeamDetail
import com.man.sport.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), TeamNavigator {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var teamAdapter: TeamAdapter
    private var data: MutableList<TeamDetail> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeViewModel = HomeViewModel(Injection.provideTeamRepository(this), this)
        homeViewModel.setNavigator(this)
        homeViewModel.getListTeam()

        initAdapter()

    }

    fun initAdapter(){
        teamAdapter = TeamAdapter(data)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = TeamAdapter(data)
    }

    override fun loadListTeam(listTeam: MutableList<TeamDetail>) {
        data.addAll(listTeam)
        teamAdapter.notifyDataSetChanged()
    }

    override fun errorLoadTeam(message: String) {
        Log.e("ERROR", message)
    }

}
