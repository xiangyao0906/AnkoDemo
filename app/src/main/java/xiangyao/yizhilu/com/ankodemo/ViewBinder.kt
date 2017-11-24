package xiangyao.yizhilu.com.ankodemo

import android.view.View

/**
 * Created by xiangyao on 2017/11/24.
 */

interface ViewBinder<in T> {

    fun bind(t: T): View

    fun unbind(t: T)

}
