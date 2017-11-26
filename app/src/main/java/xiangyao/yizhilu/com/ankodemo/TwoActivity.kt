package xiangyao.yizhilu.com.ankodemo

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.textColor
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class TwoActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {

            textView("这是第二个页面传递过来的值是${intent.getIntExtra("id", -1)}") {
                textColor = Color.BLUE
                gravity=Gravity.CENTER
                textSize=23.0f


            }.lparams(width= matchParent,height= matchParent)

        }


    }
}
