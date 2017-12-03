package work.johntsai.kotgank

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import work.johntsai.kotgank.model.GankDataModel
import work.johntsai.kotgank.model.GankDataModelWrapper
import work.johntsai.kotgank.model.GankDataType

class MainActivity : AppCompatActivity() {

    private val context: Context = this
    private var currentTab: Int = 0
    private val ids:IntArray = intArrayOf(R.id.gank_data_menu,R.id.meizi_data_menu,R.id.video_data_menu)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager = findViewById<View>(R.id.viewPager) as ViewPager
        val pagerAdapter = GankPagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter



        val navigationView = findViewById<View>(R.id.bottomNavigationView) as BottomNavigationView
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

        viewPager.addOnPageChangeListener(object:ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                navigationView.selectedItemId = ids[position]
            }

        })


        val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://gank.io/api/")
                .client(OkHttpClient())
        val retrofit = retrofitBuilder.build()
        val gankClient = retrofit.create(GankClient::class.java)

        val call = gankClient.getGankDataByType(GankDataType.WELFARE.value, 10, 1)

        call.enqueue(object : Callback<GankDataModelWrapper<GankDataModel>> {
            override fun onFailure(call: Call<GankDataModelWrapper<GankDataModel>>?, t: Throwable?) {
                Log.d("cj", t?.message)
            }

            override fun onResponse(call: Call<GankDataModelWrapper<GankDataModel>>?, response: Response<GankDataModelWrapper<GankDataModel>>?) {
                if (response != null) {
                    if (response.isSuccessful) {
                        response.body()?.results?.forEach { Log.d("cj", it.toString()) }
                    }
                }
            }

        })

    }
}
