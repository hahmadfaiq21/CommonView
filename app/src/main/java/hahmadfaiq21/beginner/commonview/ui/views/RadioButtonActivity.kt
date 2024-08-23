package hahmadfaiq21.beginner.commonview.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hahmadfaiq21.beginner.commonview.data.ItemViews
import hahmadfaiq21.beginner.commonview.databinding.ActivityRadioButtonBinding

class RadioButtonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRadioButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRadioButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        val data = intent.getParcelableExtra<ItemViews>(EXTRA_DATA) as ItemViews
        data.let {
            binding.ivImage.setImageResource(it.photo)
            binding.tvTitle.text = it.name
        }
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.radioButton1.id -> {
                    binding.tvResult.text = binding.radioButton1.text
                }
                binding.radioButton2.id -> {
                    binding.tvResult.text = binding.radioButton2.text
                }
                binding.radioButton3.id -> {
                    binding.tvResult.text = binding.radioButton3.text
                }
            }
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}