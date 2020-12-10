package com.manue.smanuefy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_grid_view.*

class GridView : AppCompatActivity(), AdapterView.OnItemClickListener {
    private var arrayList : ArrayList<AlbumItem>? = null
    private var albumAdapters : AlbumAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        arrayList = ArrayList()
        arrayList = setDataList()
        albumAdapters = AlbumAdapter(applicationContext, arrayList!!)
        gridView1.adapter = albumAdapters

        gridView1.onItemClickListener = this
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

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}