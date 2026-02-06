package com.digitalrecord.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.digitalrecord.app.data.local.AppDatabase
import com.digitalrecord.app.data.local.HouseEntity
import com.digitalrecord.app.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val db by lazy { AppDatabase.getDatabase(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            val house = HouseEntity(
                houseNumber = binding.houseNo.text.toString(),
                headName = binding.headName.text.toString(),
                totalMembers = binding.members.text.toString().toInt()
            )

            lifecycleScope.launch {
                db.houseDao().insertHouse(house)
            }
        }
    }
}
