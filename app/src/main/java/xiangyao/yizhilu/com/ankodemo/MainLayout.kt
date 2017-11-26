package xiangyao.yizhilu.com.ankodemo

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by xiangyao on 2017/11/24.
 *
 * anko 只是扩展库
 */
class MainLayout : ViewBinder<MainActivity> {


    override fun bind(mainActivity: MainActivity): View = mainActivity.UI {


        linearLayout {
            configuration(orientation = Orientation.PORTRAIT) {

                mainActivity.recycView = recyclerView {
                    init()
                }.lparams(width = matchParent, height = matchParent)
            }
        }

    }.view

    override fun unbind(t: MainActivity) {
        t.recycView = null
    }

    private fun RecyclerView.init() {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        adapter = SimpleItemRecyclerViewAdapter(DummyContent.ITEMS)
    }

}