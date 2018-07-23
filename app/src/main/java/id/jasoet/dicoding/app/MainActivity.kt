package id.jasoet.dicoding.app

import android.os.Bundle
import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import id.jasoet.dicoding.app.adapter.RecyclerViewAdapter
import id.jasoet.dicoding.app.data.Item
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainUi = MainActivityUI()
        mainUi.setContentView(this)

        val items = initData()

        mainUi.recyclerView.adapter = RecyclerViewAdapter(items) {
            startActivity<DetailActivity>("item" to it)
        }
    }

    private fun initData(): List<Item> {
        val name = resources.getStringArray(R.array.club_name)
        val description = resources.getStringArray(R.array.club_description)
        val image = resources.obtainTypedArray(R.array.club_image)

        val result = name.mapIndexed { i, itemName ->
            Item(itemName, image.getResourceId(i, 0), description[i])
        }

        image.recycle()
        return result
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
