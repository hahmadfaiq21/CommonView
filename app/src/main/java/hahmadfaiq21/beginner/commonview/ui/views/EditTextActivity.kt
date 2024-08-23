package hahmadfaiq21.beginner.commonview.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hahmadfaiq21.beginner.commonview.data.ItemViews
import hahmadfaiq21.beginner.commonview.databinding.ActivityEditTextBinding

class EditTextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        val data = intent.getParcelableExtra<ItemViews>(EXTRA_DATA) as ItemViews
        data.let {
            binding.ivImage.setImageResource(it.photo)
            binding.tvTitle.text = it.name
        }

        binding.button.setOnClickListener {
            val result = binding.editText.text.toString()
            binding.tvResult.text = result
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}