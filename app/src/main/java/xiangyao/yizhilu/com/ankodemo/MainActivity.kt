package xiangyao.yizhilu.com.ankodemo

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.Appcompat
import org.jetbrains.anko.design.snackbar


class MainActivity : AppCompatActivity() {

    var recycView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(MainLayout().bind(this))

        recycView?.addOnItemTouchListener(ItemClickListener(recycView, ItemClickListener.OnItemClickListener { view, position ->

            when (position) {

                0 -> snackbar(view, "您点击的位置是$position")
                1 -> snackbar(view, "Action, reaction", "Click me!") { doselector() }
                2 -> snackbar(view, "Action, reaction", "Click me!") { doStuff(position) }
                3 -> snackbar(view, "Action, reaction", "Click me!") { doAler() }
                4 -> snackbar(view, "Action, reaction", "Click me!") { doAppcompat() }
                5 -> snackbar(view, "Action, reaction", "Click me!") { docustomView() }
            }


        }))


    }

    private fun doStuff(position: Int) {
        toast("您点击的位置是$position")

    }

    private fun doAler() {
        alert("Hi, I'm Roy", "Have you tried turning it off and on again?") {
            yesButton { toast("Oh…") }
            noButton {}
        }.show()


    }

    private fun doAppcompat() {
        alert(Appcompat, "Hi, I'm Roy", "Have you tried turning it off and on again?") {
            yesButton { toast("Oh…") }
            noButton {}
        }.show()


    }

    private fun docustomView() {
        alert {
            customView {
                editText()
            }
        }.show()

    }


    /**
     * intent 的一些隐士跳转
     * */
    private fun doselector() {
        val countries = listOf("toast", "startIntent", "browser", "makeCall")
        selector("几种隐式跳转的例子", countries, { _, i ->

            when (i) {
                0 -> toast("So you're living in ${countries[i]}, right?")
                1 -> startActivity(intentFor<TwoActivity>("id" to 5))
                2 -> browse("http://www.jianshu.com/p/089fb79e308b")
                3 -> callMethod()
            }

        })

    }


    /**
     * 动态权限的申请
     *
     * 多个权限的申请 道理一样
     *
     * */
    val REQUEST_CODE_ASK_CALL_PHONE = 123

    private fun callMethod() {


        if (Build.VERSION.SDK_INT >= 23) {
            val checkCallPhonePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
            if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), REQUEST_CODE_ASK_CALL_PHONE)
                return
            } else {
                //上面已经写好的拨号方法
                makeCall(15141755385.toString())
            }
        } else {
            //上面已经写好的拨号方法
            makeCall(15141755385.toString())
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_CODE_ASK_CALL_PHONE -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                makeCall(15141755385.toString())
            } else {
                // Permission Denied

                toast("CALL_PHONE Denied")
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }


}
