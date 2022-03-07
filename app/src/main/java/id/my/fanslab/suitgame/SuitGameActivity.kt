package id.my.fanslab.suitgame

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import id.my.fanslab.suitgame.databinding.ActivitySuitGameBinding

class SuitGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuitGameBinding
    private var playerOption: Int = 0
    private var awayOption: Int = 0
    private val resetGame = { _: DialogInterface, _: Int ->
        playerOption = 0
        awayOption = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuitGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        binding.btnPlay.setOnClickListener {
            checkGame()
            resetGame()
        }
        binding.playerPapper.setOnClickListener {
            if (playerOption == 1) playerOption = 0 else {
                playerOption = 1
                binding.playerSelected.setImageResource(R.drawable.hand_papper)
            }
            mapVisibility()
        }
        binding.playerScissors.setOnClickListener {
            if (playerOption == 2) playerOption = 0 else {
                playerOption = 2
                binding.playerSelected.setImageResource(R.drawable.hand_scissors)
            }
            mapVisibility()
        }
        binding.playerRock.setOnClickListener {
            if (playerOption == 3) playerOption = 0 else {
                playerOption = 3
                binding.playerSelected.setImageResource(R.drawable.hand_rock)
            }
            mapVisibility()
        }

        binding.awayPapper.setOnClickListener {
            if (awayOption == 1) awayOption = 0 else {
                awayOption = 1
                binding.awaySelected.setImageResource(R.drawable.hand_papper)
            }
            mapVisibility()
        }
        binding.awayScissors.setOnClickListener {
            if (awayOption == 2) awayOption = 0 else {
                awayOption = 2
                binding.awaySelected.setImageResource(R.drawable.hand_scissors)
            }
            mapVisibility()
        }
        binding.awayRock.setOnClickListener {
            if (awayOption == 3) awayOption = 0 else {
                awayOption = 3
                binding.awaySelected.setImageResource(R.drawable.hand_rock)
            }
            mapVisibility()
        }
    }

    private fun checkGame() {
        val result: String

        if (playerOption == 0 || awayOption == 0)
            result = "Please choose your option"
        else if (playerOption == 1) {
            result = when (awayOption) {
                1 -> "Draw! No one win this game!"
                2 -> "Player 2 Win!"
                else -> "Player 1 Win!"
            }
        }
        else if (playerOption == 2) {
            result = when (awayOption) {
                1 -> "Player 2 Win!"
                2 -> "Draw! No one win this game!"
                else -> "Player 1 Win!"
            }
        } else {
            result = when (awayOption) {
                1 -> "Player 1 Win!"
                2 -> "Player 2 Win!"
                else -> "Draw! No one win this game!"
            }
        }

        val builder = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogCustom))
        with(builder) {
            setTitle("Game Alert")
            setMessage(result)
            setPositiveButton("OK", DialogInterface.OnClickListener(function = resetGame))
            show()
        }
    }

    private fun mapVisibility() = with(binding) {
        if (playerOption == 0)
            playerSelected.visibility = View.GONE
        else
            playerSelected.visibility = View.VISIBLE

        if (awayOption == 0)
            awaySelected.visibility = View.GONE
        else
            awaySelected.visibility = View.VISIBLE
    }

    private fun resetGame() = with(binding) {
        playerOption = 0
        awayOption = 0

        mapVisibility()
    }

    private fun setupUI() = with(binding) {
        tvPlayerInfo.text = getString(R.string.tv_player_info)
        tvAwayInfo.text = getString(R.string.tv_away_info)

        mapVisibility()
    }
}