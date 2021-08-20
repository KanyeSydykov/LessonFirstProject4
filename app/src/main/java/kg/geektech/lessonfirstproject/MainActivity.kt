package kg.geektech.lessonfirstproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.lessonfirstproject.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForActivity()
        setupListener()
    }

    private fun setupListener() {
        binding.intentButtonActivityMain.setOnClickListener {
            if (binding.intentEditTextActivityMain.text.toString() == "") {
                Toast.makeText(
                    this, (R.string.warning1),
                    Toast.LENGTH_SHORT
                ).show()
            } else openActivity()
        }
    }

    private fun registerForActivity() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.intentEditTextActivityMain.setText(
                        result.data?.getStringExtra(
                            EXTRA_MESSAGE
                        )
                    )

                }
            }
    }

    private fun openActivity() {
        val intent = Intent(this, ActivityTwo::class.java).apply {
            putExtra(EXTRA_MESSAGE, binding.intentEditTextActivityMain.text.toString())
        }
        resultLauncher.launch(intent)
    }

}





