package com.manue.smanuefy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var arrayList : ArrayList<AlbumItem>? = ArrayList()
    private var albumAdapters : AlbumAdapter? = null
    lateinit var context : Context

    fun RecyclerAdapter(albumes : ArrayList<AlbumItem>, context: Context) {
        this.arrayList = albumes
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.cardview_item_grid, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val item = arrayList!!.get(position)
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return arrayList?.size!!
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(album : AlbumItem, context : Context) {
            var arrayList1: ArrayList<AlbumItem> = ArrayList()

            arrayList1.add(AlbumItem(R.drawable.musica, "PlayList Manue"))
            arrayList1.add(AlbumItem(R.drawable.musica, "PlayList Carlos"))
            arrayList1.add(AlbumItem(R.drawable.musica, "PlayList Joni"))
            arrayList1.add(AlbumItem(R.drawable.musica, "PlayList Patri"))
            arrayList1.add(AlbumItem(R.drawable.musica, "PlayList Yisus"))

        }
    }

}