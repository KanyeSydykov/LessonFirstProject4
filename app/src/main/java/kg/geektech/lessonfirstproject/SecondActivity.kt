package kg.geektech.lessonfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kg.geektech.lessonfirstproject.databinding.ActivitySecondBinding

const val edit3 = "edit2"

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edit1: String? = intent.getStringExtra("edit1")
        binding.intentEditTextActivitySecond.setText(edit1)

        binding.intentButtonActivityMain.setOnClickListener {
            val edit2: String = binding.intentEditTextActivitySecond.text.toString()

            if (binding.intentEditTextActivitySecond.text.toString() == "") {
                Toast.makeText(
                    this, getString(R.string.warning1),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(edit3, edit2)
                startActivityForResult(intent, MainActivity.oboba)
                setResult(RESULT_OK, intent)
                finish()
            }
        }

    }
}