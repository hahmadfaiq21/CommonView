package hahmadfaiq21.beginner.commonview.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hahmadfaiq21.beginner.commonview.data.ItemViews
import hahmadfaiq21.beginner.commonview.databinding.ActivityProgressBarBinding

class ProgressBarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProgressBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        val data = intent.getParcelableExtra<ItemViews>(EXTRA_DATA) as ItemViews
        data.let {
            binding.ivImage.setImageResource(it.photo)
            binding.tvTitle.text = it.name
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}