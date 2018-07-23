package id.jasoet.dicoding.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import id.jasoet.dicoding.app.adapter.RecyclerViewAdapter
import id.jasoet.dicoding.app.data.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        club_list.adapter = RecyclerViewAdapter(this, items){
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        items.clear()

        for (i in name.indices) {
            items.add(Item(name[i], image.getResourceId(i, 0)))
        }

        image.recycle()
    }
}
