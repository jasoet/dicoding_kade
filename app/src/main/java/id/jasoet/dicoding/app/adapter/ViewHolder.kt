package id.jasoet.dicoding.app.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import id.jasoet.dicoding.app.data.Item
import id.jasoet.dicoding.app.ui.ListItem

class ViewHolder(val view: View, private val listItem: ListItem) : RecyclerView.ViewHolder(view) {

    fun bindItem(item: Item, listener: (Item) -> Unit) {
        listItem.textView.text = item.name
        Glide.with(itemView.context).load(item.image).into(listItem.imageView)

        itemView.setOnClickListener {
            listener(item)
        }
    }
}
