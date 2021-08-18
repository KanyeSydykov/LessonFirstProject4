package kg.geektech.lessonfirstproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kg.geektech.lessonfirstproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edit2: String? = intent.getStringExtra("edit2")
        binding.intentEditTextActivityMain.setText(edit2)

        binding.intentButtonActivityMain.setOnClickListener {
            val edit1: String = binding.intentEditTextActivityMain.text.toString()

            if (binding.intentEditTextActivityMain.text.toString() == "") {
                Toast.makeText(this, " Please enter some message! ",
                    Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("edit1", edit1)
                startActivity(intent)
            }
        }


    }

}


