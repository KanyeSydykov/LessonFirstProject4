package kg.geektech.lessonfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kg.geektech.lessonfirstproject.databinding.ActivitySecondBinding

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
                Toast.makeText(this, " Please enter some message! ",
                    Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("edit2", edit2)
                startActivity(intent)
            }
        }

    }
}