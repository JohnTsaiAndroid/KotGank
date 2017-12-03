package work.johntsai.kotgank

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import work.johntsai.kotgank.model.GankDataModel

class MeiziRecyclerViewAdapter(val datas: List<GankDataModel>?, val context: Context) : RecyclerView.Adapter<MeiziRecyclerViewAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        datas?.let {
            val data = datas[position]
            Glide.with(context).load(data.url).into(holder?.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_meizi, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount():Int{
        if(datas == null){
            return 0
        }
        return datas.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<View>(R.id.image) as ImageView
    }
}