package hahmadfaiq21.beginner.commonview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvViews: RecyclerView
    private val list = ArrayList<ItemView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvViews = findViewById(R.id.rv_views)
        rvViews.setHasFixedSize(true)
        list.addAll(getListViews())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvViews.layoutManager = LinearLayoutManager(this)
        rvViews.adapter = ListViewAdapter(list)
    }

    private fun getListViews(): ArrayList<ItemView> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listViews = ArrayList<ItemView>()
        for (i in dataName.indices) {
        val itemView = ItemView(dataName[i], dataPhoto.getResourceId(i, -1))
            listViews.add(itemView)
        }
        dataPhoto.recycle()
        return listViews
    }
}