package work.johntsai.kotgank.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by John on 2017/12/6.
 */
fun ViewGroup.inflate(inflateId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(inflateId, this, attachToRoot)
}

fun ImageView.loadImage(url:String){
    Glide.with(context).load(url).into(this)
}

