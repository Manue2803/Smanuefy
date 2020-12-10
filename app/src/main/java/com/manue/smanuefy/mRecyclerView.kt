package com.manue.smanuefy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*

class mRecyclerView : AppCompatActivity() {

    lateinit var mRecyclerView1 : RecyclerView
    val mAdapter : RecyclerAdapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        mRecyclerView1 = albumRecycler
        mRecyclerView1.setHasFixedSize(true)
        mRecyclerView1.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(setDataList(), this)
        mRecyclerView1.adapter = mAdapter

    }

    private fun setDataList() : ArrayList<AlbumItem> {
        var arrayList : ArrayList<AlbumItem> = ArrayList()

        arrayList.add(AlbumItem(R.drawable.musica, "PlayList Manue"))
        arrayList.add(AlbumItem(R.drawable.musica, "PlayList Carlos"))
        arrayList.add(AlbumItem(R.drawable.musica, "PlayList Joni"))
        arrayList.add(AlbumItem(R.drawable.musica, "PlayList Patri"))
        arrayList.add(AlbumItem(R.drawable.musica, "PlayList Yisus"))

        return arrayList
    }

}