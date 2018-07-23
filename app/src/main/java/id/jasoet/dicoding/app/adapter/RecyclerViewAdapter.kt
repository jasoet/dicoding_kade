package id.jasoet.dicoding.app.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import id.jasoet.dicoding.app.data.Item
import id.jasoet.dicoding.app.ui.ListItem
import org.jetbrains.anko.AnkoContext

class RecyclerViewAdapter(private val items: List<Item>, private val listener: (Item) -> Unit) :
        RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val ui = AnkoContext.create(parent.context, parent)
        val listItem = ListItem()
        val view = listItem.createView(ui)

        return ViewHolder(view, listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}