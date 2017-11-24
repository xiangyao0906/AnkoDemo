package xiangyao.yizhilu.com.ankodemo

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class AnkoTestActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        verticalLayout {
            val name = editText()
            name.hint = "快来打个招呼吧"
            name.hintTextColor = Color.GRAY
            button("Say Hello") {
                backgroundColor = Color.GRAY
                onClick { toast("Hello, ${name.text}!") }
            }
        }
    }
}
