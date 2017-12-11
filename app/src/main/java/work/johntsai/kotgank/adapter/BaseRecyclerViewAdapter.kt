package work.johntsai.kotgank.adapter

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup

/**
 * Created by John on 2017/12/10.
 */
abstract class BaseRecyclerViewAdapter<in T>(private val dataList: List<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ITEM = 0
    }

    private var viewHolderMap = SparseArray<Class<out RecyclerView.ViewHolder>>()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val data = dataList[position]
        bindViewHolder(data, holder)
    }

    fun registerViewHolder(type: Int, holder: Class<out RecyclerView.ViewHolder>) {
        viewHolderMap.put(type, holder)
    }

    fun release() {
        viewHolderMap.clear()
    }

    abstract fun bindViewHolder(data: T, holder: RecyclerView.ViewHolder?)

    abstract fun createViewHolder(parent: ViewGroup?): View

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = viewHolderMap[viewType]
        val view = createViewHolder(parent)
        if (viewHolder == null) {
            throw NullPointerException("The ViewHolder class cannot be null.")
        }
        return viewHolder.getConstructor(View::class.java).newInstance(view)

    }
}