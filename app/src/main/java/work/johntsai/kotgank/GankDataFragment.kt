package work.johntsai.kotgank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class GankDataFragment:BaseFragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_gank_data,container,false)
    }
}