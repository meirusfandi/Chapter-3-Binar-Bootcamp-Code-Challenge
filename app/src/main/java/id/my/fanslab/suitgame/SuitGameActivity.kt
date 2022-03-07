package id.my.fanslab.suitgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.my.fanslab.suitgame.databinding.ActivitySuitGameBinding

class SuitGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuitGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuitGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAction()
    }

    private fun setupAction() = with(binding) {

    }
}