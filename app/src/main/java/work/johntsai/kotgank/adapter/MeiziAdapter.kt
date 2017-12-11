package work.johntsai.kotgank.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.item_meizi.view.*
import work.johntsai.kotgank.R
import work.johntsai.kotgank.common.inflate
import work.johntsai.kotgank.common.loadImage
import work.johntsai.kotgank.model.GankDataModel

/**
 * Created by John on 2017/12/10.
 */
class MeiziAdapter(val dataList:List<GankDataModel>):BaseRecyclerViewAdapter<GankDataModel>(dataList){
    override fun bindViewHolder(data: GankDataModel, holder: RecyclerView.ViewHolder?) {
        if(holder is MeiziViewHolder){
            holder.imageView.loadImage(data.url)
        }
    }

    override fun createViewHolder(parent: ViewGroup?): View {
        return parent!!.inflate(R.layout.item_meizi)
    }


    class MeiziViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imageView = itemView.image as ImageView
    }


}