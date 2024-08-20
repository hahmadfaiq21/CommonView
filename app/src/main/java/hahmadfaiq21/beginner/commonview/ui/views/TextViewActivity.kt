package hahmadfaiq21.beginner.commonview.ui.views

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hahmadfaiq21.beginner.commonview.data.ItemView
import hahmadfaiq21.beginner.commonview.databinding.ActivityTextViewBinding

class TextViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTextViewBinding

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_DATA, ItemView::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DATA)
        }

        data?.let {
            binding.ivImage.setImageResource(it.photo)
            binding.tvTitle.text = it.name
        }
    }
}