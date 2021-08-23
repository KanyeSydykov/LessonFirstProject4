package kg.geektech.lessonfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.lessonfirstproject.MainActivity.Companion.KEY_RES
import kg.geektech.lessonfirstproject.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: RecyclerAdapter
    private lateinit var userList: ArrayList<UserData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this)
        binding.rvActivityThird.layoutManager = layoutManager

         val ss:String = intent.getStringExtra(KEY_RES).toString()
        userList.add(UserData("Name: $ss"))
        adapter.notifyDataSetChanged()

    }
}