package work.johntsai.kotgank.ui

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_meizi.view.*
import work.johntsai.kotgank.R
import work.johntsai.kotgank.RecyclerViewOnLoadMoreListener
import work.johntsai.kotgank.RetrofitClient
import work.johntsai.kotgank.adapter.BaseRecyclerViewAdapter
import work.johntsai.kotgank.adapter.MeiziAdapter
import work.johntsai.kotgank.common.inflate
import work.johntsai.kotgank.model.GankDataModel
import work.johntsai.kotgank.model.GankDataType

class MeiziFragment : BaseFragment() {

    private lateinit var recyclerView:RecyclerView
    private var datas = ArrayList<GankDataModel>()
    private var currentPage = 1
    private lateinit var adapter:MeiziAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.fragment_meizi)
        view?.let {
            recyclerView = view.recyclerView as RecyclerView
            adapter = MeiziAdapter(datas)
            adapter.registerViewHolder(BaseRecyclerViewAdapter.VIEW_TYPE_ITEM,MeiziAdapter.MeiziViewHolder::class.java)
            recyclerView.adapter = adapter

            val gankService = RetrofitClient().getGankService()
            gankService?.let {
                gankService.getGankDataByType(GankDataType.WELFARE.value,10,currentPage)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                {result->
                                    datas.addAll(result.results)
                                    adapter.notifyDataSetChanged()
                                },
                                {Log.d("cj","error in get data")},
                                {Log.d("cj","Completed!")}
                        )
            }
            recyclerView.addOnScrollListener(RecyclerViewOnLoadMoreListener({
                gankService?.let {
                    gankService.getGankDataByType(GankDataType.WELFARE.value,10,++currentPage)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    {result->
                                        datas.addAll(result.results)
                                        adapter.notifyDataSetChanged()
                                    },
                                    {Log.d("cj","error in get data")},
                                    {Log.d("cj","Completed!")}
                            )
                }
            }))
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        adapter.release()
    }
}