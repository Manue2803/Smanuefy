package com.manue.smanuefy

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AlbumAdapter(var context: Context, var arrayList : ArrayList<AlbumItem>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view : View = View.inflate(context, R.layout.cardview_item_grid, null)
        var icons : ImageView = view.findViewById(R.id.imageView3)
        var name : TextView = view.findViewById(R.id.textView3)
        var listItem : AlbumItem = arrayList.get(position)
        icons.setImageResource(listItem.icons!!)
        name.text = listItem.name
        return view
    }

}