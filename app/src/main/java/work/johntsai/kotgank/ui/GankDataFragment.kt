package work.johntsai.kotgank.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import work.johntsai.kotgank.R
import work.johntsai.kotgank.common.inflate

class GankDataFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_gank_data)
    }
}