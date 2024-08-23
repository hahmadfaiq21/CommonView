package hahmadfaiq21.beginner.commonview.ui

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import hahmadfaiq21.beginner.commonview.R
import hahmadfaiq21.beginner.commonview.ui.views.TextViewActivity
import hahmadfaiq21.beginner.commonview.adapter.ListViewAdapter
import hahmadfaiq21.beginner.commonview.data.ItemViews
import hahmadfaiq21.beginner.commonview.databinding.ActivityMainBinding
import hahmadfaiq21.beginner.commonview.ui.views.ButtonActivity
import hahmadfaiq21.beginner.commonview.ui.views.CheckBoxActivity
import hahmadfaiq21.beginner.commonview.ui.views.EditTextActivity
import hahmadfaiq21.beginner.commonview.ui.views.ImageViewActivity
import hahmadfaiq21.beginner.commonview.ui.views.RadioButtonActivity
import hahmadfaiq21.beginner.commonview.ui.views.SpinnerActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<ItemViews>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvViews.setHasFixedSize(true)
        list.addAll(getListViews())
        showRecyclerList()

        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvViews.layoutManager = GridLayoutManager(this, 2)
        } else {
            binding.rvViews.layoutManager = LinearLayoutManager(this)
        }
    }

    private fun showRecyclerList() {
        binding.rvViews.layoutManager = LinearLayoutManager(this)
        val listViewAdapter = ListViewAdapter(list)
        binding.rvViews.adapter = listViewAdapter
        listViewAdapter.setOnItemClickCallback(object : ListViewAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ItemViews) {
                when (data.name) {
                    resources.getStringArray(R.array.data_name)[0] -> {
                        Intent(this@MainActivity, TextViewActivity::class.java).also {
                            it.putExtra(TextViewActivity.EXTRA_DATA, data)
                            startActivity(it)
                        }
                    }
                    resources.getStringArray(R.array.data_name)[1] -> {
                        Intent(this@MainActivity, ImageViewActivity::class.java).also {
                            it.putExtra(ImageViewActivity.EXTRA_DATA, data)
                            startActivity(it)
                        }
                    }
                    resources.getStringArray(R.array.data_name)[2] -> {
                        Intent(this@MainActivity, ButtonActivity::class.java).also {
                            it.putExtra(ButtonActivity.EXTRA_DATA, data)
                            startActivity(it)
                        }
                    }
                    resources.getStringArray(R.array.data_name)[3] -> {
                        Intent(this@MainActivity, EditTextActivity::class.java).also {
                            it.putExtra(EditTextActivity.EXTRA_DATA, data)
                            startActivity(it)
                        }
                    }
                    resources.getStringArray(R.array.data_name)[4] -> {
                        Intent(this@MainActivity, SpinnerActivity::class.java).also {
                            it.putExtra(SpinnerActivity.EXTRA_DATA, data)
                            startActivity(it)
                        }
                    }
                    resources.getStringArray(R.array.data_name)[5] -> {
                        Intent(this@MainActivity, CheckBoxActivity::class.java).also {
                            it.putExtra(CheckBoxActivity.EXTRA_DATA, data)
                            startActivity(it)
                        }
                    }
                    resources.getStringArray(R.array.data_name)[6] -> {
                        Intent(this@MainActivity, RadioButtonActivity::class.java).also {
                            it.putExtra(RadioButtonActivity.EXTRA_DATA, data)
                            startActivity(it)
                        }
                    }
                }
            }
        })
    }

    private fun getListViews(): ArrayList<ItemViews> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listViews = ArrayList<ItemViews>()

        for (i in dataName.indices) {
            val viewItems = ItemViews(dataName[i], dataPhoto.getResourceId(i, -1))
            listViews.add(viewItems)
        }

        dataPhoto.recycle()
        return listViews
    }

}