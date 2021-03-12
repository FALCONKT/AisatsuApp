package jp.techacademy.kenji.takada.aisatsuapp

import android.support.v7.app.AppCompatActivity

import android.os.Bundle

//AlertDialog 用　追加
import android.support.v7.app.AlertDialog

//Log.d()　用　追加
import android.util.Log

//View　用　追加
import android.view.View

//activity_main　と接続用
import kotlinx.android.synthetic.main.activity_main.*

//TimePickerDialog 用
import android.app.TimePickerDialog


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }
//    onCreat　END


//    Clickされたときすること　Method定義
    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
            showTimePickerDialog()
//            textchamge()
        }
    }

//

//    時計表示　Method定義
    private fun showTimePickerDialog() {

        val timePickerDialog =
        TimePickerDialog(
        this,
        TimePickerDialog.OnTimeSetListener { view, hour, minute ->
            Log.d("UI_PARTS", "$hour:$minute")

//            ！！！！！！！！！！！！！！！！！！
//            その変数を用いて　文字表記を変更する
            if ((2 <= hour && hour <= 9) && (0 <= minute && minute <= 59)) {
                textView.text = "おはよう"
            } else if ((10 <= hour && hour <= 17) && (0 <= minute && minute <= 59)) {
                textView.text = "こんにちわ"
            } else if ((18 <= hour && hour <= 24) && (0 <= minute && minute <= 59)) {
                textView.text = "こんばんわ"
            } else if ((0 <= hour && hour <= 1) && (0 <= minute && minute <= 59)) {
                textView.text = "こんばんわ"
            } else {
                textView.text = "設定がおかしいです"
            }

        },
        13, 0, true
        )

        timePickerDialog.show()
    }
//    showTimePickerDialoND



}
//Class END
