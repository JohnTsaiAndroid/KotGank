package work.johntsai.kotgank

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient{

    private val retrofit:Retrofit = Retrofit
            .Builder()
            .baseUrl("http://gank.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()

    fun getInstance() = retrofit

    fun getGankService(): GankClient? {
       return retrofit.create(GankClient::class.java)
    }



}
