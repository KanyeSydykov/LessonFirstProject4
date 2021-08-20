package kg.geektech.lessonfirstproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Toast
import kg.geektech.lessonfirstproject.databinding.ActivitySecondBinding



class ActivityTwo : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkIntent()
        setupListener()
    }

    private fun checkIntent() {
        binding.intentEditTextActivitySecond.setText(intent.getStringExtra(EXTRA_MESSAGE))
    }

    private fun setupListener() {
        binding.intentButtonActivitySecond.setOnClickListener {
            if (binding.intentEditTextActivitySecond.text.toString() == "") {
                Toast.makeText(
                    this, (R.string.warning1),
                    Toast.LENGTH_SHORT
                ).show()
            } else openActivity()
        }
    }

    private fun openActivity() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, binding.intentEditTextActivitySecond.text.toString())
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
