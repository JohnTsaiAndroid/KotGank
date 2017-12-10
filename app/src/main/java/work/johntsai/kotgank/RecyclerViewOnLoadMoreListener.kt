package work.johntsai.kotgank

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager


/**
 * Created by John on 2017/12/10.
 */
class RecyclerViewOnLoadMoreListener(val callback:Callback): RecyclerView.OnScrollListener(){


    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if(dy > 0){//上滑
            var visiableItemCount = 0//当前可见的Item总数
            var totalItemCount = 0//所有Item个数
            var firstVisableItem = 0//当前第一个Item的位置

            val layoutManager = recyclerView!!.layoutManager
            when(layoutManager){
                is LinearLayoutManager->{
                    visiableItemCount = layoutManager.childCount
                    totalItemCount = layoutManager.itemCount
                    firstVisableItem = layoutManager.findFirstVisibleItemPosition()
                }
                is GridLayoutManager->{
                    visiableItemCount = layoutManager.childCount
                    totalItemCount = layoutManager.itemCount
                    firstVisableItem = layoutManager.findFirstVisibleItemPosition()

                }
                is StaggeredGridLayoutManager->{
                    visiableItemCount = layoutManager.childCount
                    totalItemCount = layoutManager.itemCount
                    firstVisableItem = layoutManager.findFirstVisibleItemPositions(IntArray(layoutManager.spanCount))[0]

                }
                else->{
                    throw RuntimeException("UnExpected LayoutManager:$layoutManager")
                }
            }
            if(visiableItemCount+firstVisableItem>=totalItemCount){
                callback.onLoad()
            }


        }
    }

    interface Callback{
        fun onLoad()
    }


}