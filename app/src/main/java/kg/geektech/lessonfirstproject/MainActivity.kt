package kg.geektech.lessonfirstproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

import kg.geektech.lessonfirstproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var adapter:RecyclerAdapter
    private lateinit var userList: ArrayList<UserData>
    private lateinit var binding: ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        registerForActivity()
        setupListener()
        openRecyclerView()
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

    private fun openRecyclerView() {
        binding.rvButtonActivityMain.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java).apply {
                val names = binding.intentEditTextActivityMain.text.toString()
                userList.add(UserData("Name: $names"))
                adapter.notifyDataSetChanged()
                putExtra(names, binding.intentEditTextActivityMain.text.toString())

            }
            resultLauncher.launch(intent)
        }

    }

    private fun registerForActivity() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    binding.intentEditTextActivityMain.setText(
                        result.data?.getStringExtra(
                            KEY_RES
                        )
                    )

                }
            }
    }

    private fun openActivity() {
        val intent = Intent(this, ActivityTwo::class.java).apply {
            putExtra(KEY_RES, binding.intentEditTextActivityMain.text.toString())
        }
        resultLauncher.launch(intent)
    }

    companion object {
        const val KEY_RES = "res"
    }

    private fun addInfo(){
      val names = binding.intentEditTextActivityMain.text.toString()
      userList.add(UserData("Name: $names"))
      adapter.notifyDataSetChanged()



    }

}





