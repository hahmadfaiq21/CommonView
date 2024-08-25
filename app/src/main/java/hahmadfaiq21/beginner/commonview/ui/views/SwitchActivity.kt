package hahmadfaiq21.beginner.commonview.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hahmadfaiq21.beginner.commonview.data.ItemViews
import hahmadfaiq21.beginner.commonview.databinding.ActivitySwitchBinding

class SwitchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySwitchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwitchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        val data = intent.getParcelableExtra<ItemViews>(EXTRA_DATA) as ItemViews
        data.let {
            binding.ivImage.setImageResource(it.photo)
            binding.tvTitle.text = it.name
        }

        binding.switch1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.tvResult.text = binding.switch1.textOn
            } else {
                binding.tvResult.text = binding.switch1.textOff
            }
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}