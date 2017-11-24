package xiangyao.yizhilu.com.ankodemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    var recycView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(MainLayout().bind(this))


    }
}
