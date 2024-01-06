package com.example.project_nmp.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.project_nmp.MyAdapter
import com.example.project_nmp.R
import com.example.project_nmp.layout.fragment.CreateFragment
import com.example.project_nmp.layout.fragment.FollowingFragment
import com.example.project_nmp.layout.fragment.HomeFragment
import com.example.project_nmp.layout.fragment.PrefsFragment
import com.example.project_nmp.layout.fragment.UsersFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNav: BottomNavigationView
    val fragments: ArrayList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        bottomNav = findViewById(R.id.bottom_nav)

        fragments.add(HomeFragment())
        fragments.add(FollowingFragment())
        fragments.add(CreateFragment())
        fragments.add(UsersFragment())
        fragments.add(PrefsFragment())

        viewPager.adapter = MyAdapter(this, fragments)

        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itemHome -> viewPager.currentItem = 0
                R.id.itemFollowing -> viewPager.currentItem = 1
                R.id.itemCreate -> viewPager.currentItem = 2
                R.id.itemUsers -> viewPager.currentItem = 3
                R.id.itemPrefs -> viewPager.currentItem = 4
            }
            true
        }

        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                bottomNav.selectedItemId = bottomNav.menu.getItem(position).itemId
            }
        })
    }

}
