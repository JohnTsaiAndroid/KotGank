package work.johntsai.kotgank

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager


/**
 * Created by John on 2017/12/10.
 */
class RecyclerViewOnLoadMoreListener(val func:()->Unit): RecyclerView.OnScrollListener(){

    private var loading = true
    private var visibleItemCount = 0//当前可见的Item总数
    private var totalItemCount = 0//所有Item个数
    private var firstVisibleItem = 0//当前第一个Item的位置
    private var previousTotal = 0

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if(dy > 0){//上滑

            val layoutManager = recyclerView!!.layoutManager
            when(layoutManager){
                is LinearLayoutManager->{
                    visibleItemCount = layoutManager.childCount
                    totalItemCount = layoutManager.itemCount
                    firstVisibleItem = layoutManager.findFirstVisibleItemPosition()
                }
                is GridLayoutManager->{
                    visibleItemCount = layoutManager.childCount
                    totalItemCount = layoutManager.itemCount
                    firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

                }
                is StaggeredGridLayoutManager->{
                    visibleItemCount = layoutManager.childCount
                    totalItemCount = layoutManager.itemCount
                    firstVisibleItem = layoutManager.findFirstVisibleItemPositions(IntArray(layoutManager.spanCount))[0]

                }
                else->{
                    throw RuntimeException("UnExpected LayoutManager:$layoutManager")
                }
            }
            if(loading){
                if(totalItemCount > previousTotal){
                    loading = false
                    previousTotal = totalItemCount
                }
            }

            if(!loading &&(totalItemCount - visibleItemCount)<=(firstVisibleItem + 1)){
                func()
                loading = true
            }



        }
    }



}