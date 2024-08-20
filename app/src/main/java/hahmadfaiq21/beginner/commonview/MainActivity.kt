package hahmadfaiq21.beginner.commonview

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
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

        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvViews.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvViews.layoutManager = LinearLayoutManager(this)
        }
    }

    private fun showRecyclerList() {
        rvViews.layoutManager = LinearLayoutManager(this)
        val listViewAdapter = ListViewAdapter(list)
        rvViews.adapter = listViewAdapter
        listViewAdapter.setOnItemClickCallback(object : ListViewAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ItemView) {
                showSelectedView(data)
            }
        })
    }

    private fun showSelectedView(view: ItemView) {
        Toast.makeText(this, "Kamu memilih " + view.name, Toast.LENGTH_SHORT).show()
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