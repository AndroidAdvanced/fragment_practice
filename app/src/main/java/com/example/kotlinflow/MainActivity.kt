package com.example.kotlinflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlinflow.databinding.MainLayoutBinding

class MainActivity : AppCompatActivity() {

    private val fm = supportFragmentManager
    private var ft = fm.beginTransaction()
    private lateinit var binding: MainLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainLayoutBinding.inflate(layoutInflater)
        val view = binding.root

     //   setContentView(view)

//        fm.addOnBackStackChangedListener { OnBackStackChangedListener {
//                println("BackStack .. " + fm.backStackEntryCount)
//                binding.txtBackStack.text = "BackStack Count" + fm.backStackEntryCount
//            }
//        }
//
//        binding.btnAddFragment.setOnClickListener(View.OnClickListener {
//            addFragment()
//        })addFragment
    }

    private fun addFragment() {

        lateinit var fragment : Fragment

        when(fm.backStackEntryCount) {
            0 -> fragment = Fragment1()
            1 -> fragment = Fragment2()
            2 -> fragment = Fragment3()
        }

        ft = fm.beginTransaction()
        ft.add(R.id.frameLayout, fragment)
        ft.commitAllowingStateLoss()
    }
}
