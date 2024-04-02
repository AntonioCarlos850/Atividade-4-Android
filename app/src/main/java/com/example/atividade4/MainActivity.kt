package com.example.atividade4

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import com.example.atividade4.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.size.text = "10dp"
        binding.send.setOnClickListener{ setText() }
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                binding.result.textSize = progress.toFloat()
                binding.size.text = progress.toString() + "dp"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        binding.bold.setOnClickListener { styleText() }
        binding.italic.setOnClickListener { styleText() }
        binding.upper.setOnClickListener { styleText() }
        binding.radioButtonColor1.setOnClickListener { styleText() }
        binding.radioButtonColor2.setOnClickListener { styleText() }
        binding.radioButtonColor3.setOnClickListener { styleText() }
    }

    private fun setText() {
        binding.result.text = binding.mainInput.text;
        styleText()
    }

    private fun styleText() {
        binding.result.setTypeface(null, Typeface.NORMAL)
        binding.result.setTextColor(Color.BLACK)
        binding.result.paintFlags = 0
        binding.result.text = binding.result.text.toString().lowercase()

        var typeface = 0;

        if (binding.bold.isChecked) {
            typeface += Typeface.BOLD
        }

        if (binding.italic.isChecked) {
            typeface += Typeface.ITALIC
        }

        if (typeface > 0) {
            binding.result.setTypeface(null, typeface)
        }

        if (binding.upper.isChecked) {
            binding.result.text = binding.result.text.toString().uppercase()
        }

        if (binding.radioButtonColor1.isChecked) {
            binding.result.setTextColor(Color.RED)
        }

        if (binding.radioButtonColor2.isChecked) {
            binding.result.setTextColor(Color.GREEN)
        }

        if (binding.radioButtonColor3.isChecked) {
            binding.result.setTextColor(Color.BLUE)
        }
    }

}