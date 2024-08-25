package hahmadfaiq21.beginner.commonview.ui.views

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import hahmadfaiq21.beginner.commonview.data.ItemViews
import hahmadfaiq21.beginner.commonview.databinding.ActivitySeekBarBinding

class SeekBarActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySeekBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        val data = intent.getParcelableExtra<ItemViews>(EXTRA_DATA) as ItemViews
        data.let {
            binding.ivImage.setImageResource(it.photo)
            binding.tvTitle.text = it.name
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Called when the progress level is changed
                binding.tvResult.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Called when the user starts dragging the thumb
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Called when the user stops dragging the thumb
            }
        })
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}