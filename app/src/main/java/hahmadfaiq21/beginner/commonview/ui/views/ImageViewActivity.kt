package hahmadfaiq21.beginner.commonview.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hahmadfaiq21.beginner.commonview.data.ItemViews
import hahmadfaiq21.beginner.commonview.databinding.ActivityImageViewBinding

class ImageViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        val data = intent.getParcelableExtra<ItemViews>(TextViewActivity.EXTRA_DATA) as ItemViews
        data.let {
            binding.ivImage.setImageResource(it.photo)
            binding.tvTitle.text = it.name
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}