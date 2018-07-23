package id.jasoet.dicoding.app

import android.os.Bundle
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import id.jasoet.dicoding.app.adapter.RecyclerViewAdapter
import id.jasoet.dicoding.app.data.Item
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {
    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainUi = MainActivityUI()
        mainUi.setContentView(this)

        initData()

        mainUi.recyclerView.adapter = RecyclerViewAdapter(items) {
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        items.clear()

        for (i in name.indices) {
            items.add(Item(name[i], image.getResourceId(i, 0)))
        }

        image.recycle()
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        lateinit var recyclerView: RecyclerView
        override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
            constraintLayout {
                recyclerView = recyclerView {
                    layoutManager = LinearLayoutManager(ui.ctx)
                }.lparams {
                    width = matchParent
                    height = matchParent
                    bottomToBottom = PARENT_ID
                    leftToLeft = PARENT_ID
                    rightToRight = PARENT_ID
                    topToTop = PARENT_ID
                }

                recyclerView
            }
        }
    }
}
