package com.man.sport.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.man.sport.R
import com.man.sport.model.TeamDetail
import kotlinx.android.synthetic.main.item_list_team.view.*

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 21, March, 2019
 */

class TeamAdapter (private var list: MutableList<TeamDetail>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, parent: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_list_team, viewGroup, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder : ViewHolder, positon: Int) {
        holder.bindData(list[positon])
    }


}

class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    private val txtName = v.txt_team_name

    fun bindData(teamDetail: TeamDetail) {
        txtName.text = teamDetail.teamName
    }
}