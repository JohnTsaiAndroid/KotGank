package work.johntsai.kotgank

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import work.johntsai.kotgank.model.GankDataModel
import work.johntsai.kotgank.model.GankDataModelWrapper


interface GankClient {

    @GET("data/{type}/{num}/{page}")
    fun getGankDataByType(@Path("type") type: String, @Path("num") num: Int, @Path("page") page: Int): Call<GankDataModelWrapper<GankDataModel>>

}