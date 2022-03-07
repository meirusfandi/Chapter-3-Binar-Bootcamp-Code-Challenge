package id.my.fanslab.suitgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.my.fanslab.suitgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() = with(binding) {
        btnStart.setOnClickListener {
            val intent = Intent(this@MainActivity, SuitGameActivity::class.java)
            startActivity(intent)
        }
    }
}