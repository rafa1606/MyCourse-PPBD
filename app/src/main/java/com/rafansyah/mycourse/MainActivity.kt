package com.rafansyah.mycourse

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        // Toolbar
        val toolbar =
            findViewById<com.google.android.material.appbar.MaterialToolbar>(
                R.id.toolbar
            )

        setSupportActionBar(toolbar)

        // Window Insets
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v, insets ->

            val systemBars =
                insets.getInsets(
                    WindowInsetsCompat.Type.systemBars()
                )

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // ViewPager2
        val sectionsPagerAdapter = SectionsPagerAdapter(this)

        val viewPager: ViewPager2 =
            findViewById(R.id.view_pager)

        viewPager.adapter = sectionsPagerAdapter

        // TabLayout
        val tabLayout: TabLayout =
            findViewById(R.id.tab_layout)

        TabLayoutMediator(
            tabLayout,
            viewPager
        ) { tab, position ->

            when (position) {
                0 -> tab.text = "Home"
                1 -> tab.text = "Materi"
                2 -> tab.text = "Quiz"
            }

        }.attach()
    }

    // Menampilkan Option Menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    // Fungsi ketika item Option Menu ditekan
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            R.id.action_home -> {
                Toast.makeText(
                    this,
                    "Home",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.action_materi -> {
                Toast.makeText(
                    this,
                    "Materi",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.action_quiz -> {
                Toast.makeText(
                    this,
                    "Quiz",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}