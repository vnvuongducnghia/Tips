package com.example.nghiavuong.multipleclickactionsonsingletextview

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        singleTextView(txtMultipleClick, "Nghia ", "hat ", "con duong mua")
    }

    private fun singleTextView(textView: TextView, userName: String, status: String, songName: String) {
        val spanText = SpannableStringBuilder()
        Log.w("TestLog", "spanText.length ${spanText.length}")
        spanText.append(userName)
        Log.w("TestLog", "spanText.length ${spanText.length}")
        spanText.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                Log.w("TestLog", "$userName Click action")
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = ds.linkColor
                ds.isUnderlineText = false
                textView.highlightColor = Color.TRANSPARENT
            }

        }, spanText.length - userName.length, spanText.length, 0)
        spanText.append(status)
        spanText.append(songName)
        Log.w("TestLog", "spanText.length ${spanText.length}")
        spanText.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                Log.w("TestLog", "$songName Click action")
                textView.highlightColor = Color.TRANSPARENT
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.RED
                ds.isUnderlineText = false
            }
        }, spanText.length - songName.length, spanText.length, 0)
        textView.movementMethod = LinkMovementMethod.getInstance()
        textView.setText(spanText, TextView.BufferType.SPANNABLE)
    }
}
