package work.johntsai.kotgank.ui

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable


open class BaseFragment : Fragment(){

    protected var subscriptions = CompositeDisposable()

    override fun onPause() {
        super.onPause()
        if(!subscriptions.isDisposed){
            subscriptions.dispose()
        }
        subscriptions.clear()
    }

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeDisposable()
    }

}