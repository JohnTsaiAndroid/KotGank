package work.johntsai.kotgank.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import work.johntsai.kotgank.adapter.GankPagerAdapter
import work.johntsai.kotgank.R

class MainActivity : AppCompatActivity() {

    private val context: Context = this
    private var currentTab: Int = 0
    private val ids: IntArray = intArrayOf(R.id.gank_data_menu, R.id.meizi_data_menu, R.id.video_data_menu)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager = viewPager
        val pagerAdapter = GankPagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter


        val navigationView = bottomNavigationView
        navigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.meizi_data_menu -> currentTab = 1
                R.id.gank_data_menu -> currentTab = 0
                R.id.video_data_menu -> currentTab = 2
            }
            if (viewPager.currentItem != currentTab) {
                viewPager.currentItem = currentTab
            }
            true

        }

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                navigationView.selectedItemId = ids[position]
            }

        })

    }
}
