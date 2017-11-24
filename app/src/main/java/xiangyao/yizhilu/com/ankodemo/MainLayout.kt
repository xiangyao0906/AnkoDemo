package xiangyao.yizhilu.com.ankodemo

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.design.coordinatorLayout

/**
 * Created by xiangyao on 2017/11/24.
 *
 * anko 只是扩展库
 */
class MainLayout : ViewBinder<MainActivity> {


    override fun bind(mainActivity: MainActivity): View = mainActivity.UI {

        coordinatorLayout {
            linearLayout {
                configuration(orientation = Orientation.PORTRAIT) {
                    Log.i("xiangyao", "调用0")
                }
            }
        }

    }.view

    override fun unbind(t: MainActivity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun RecyclerView.init() {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        adapter = SimpleItemRecyclerViewAdapter(DummyContent.ITEMS)
    }

}