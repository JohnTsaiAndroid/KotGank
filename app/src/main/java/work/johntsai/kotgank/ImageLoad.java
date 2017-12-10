package work.johntsai.kotgank;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by John on 2017/12/10.
 * 图片加载，封装实现细节，暴露加载接口
 */

public class ImageLoad {

    private ImageLoad(){

    }


    public static void load(String url,ImageView imageView){
      Glide.with(imageView.getContext()).load(url).into(imageView);
    }


}
