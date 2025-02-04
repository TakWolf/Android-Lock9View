package com.takwolf.android.demo.lock9view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.takwolf.android.demo.lock9view.databinding.ActivityLStyleBinding
import com.takwolf.android.lock9view.Lock9View.GestureCallback

class LStyleActivity : AppCompatActivity() {
    companion object {
        fun open(activity: AppCompatActivity) {
            activity.startActivity(Intent(activity, LStyleActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT),
        )
        super.onCreate(savedInstanceState)
        val binding = ActivityLStyleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.lock9View.setGestureCallback(object : GestureCallback {
            override fun onNodeConnected(numbers: IntArray) {
                Toast.makeText(this@LStyleActivity, "+ ${numbers[numbers.size - 1]}", Toast.LENGTH_SHORT).show()
            }

            override fun onGestureFinished(numbers: IntArray) {
                val builder = StringBuilder()
                for (number in numbers) {
                    builder.append(number)
                }
                Toast.makeText(this@LStyleActivity, "= $builder", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
