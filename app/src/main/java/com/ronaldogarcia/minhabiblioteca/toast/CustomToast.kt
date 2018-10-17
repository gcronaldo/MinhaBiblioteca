package com.ronaldogarcia.minhabiblioteca.toast

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.ronaldogarcia.minhabiblioteca.R

class CustomToast(val context: Context, val inflater: LayoutInflater) {

    companion object {
        val WARNING = 1
        val SUCCESS = 2
        val INFO = 3
        val ERROR = 4
    }

    fun showToast(text: String, type: Int) {

        val customToastroot = inflater.inflate(getLayout(type), null)
        val customtoast = Toast(context)

        val textView = customToastroot.findViewById<TextView>(R.id.textView1)
        textView.text = text

        customtoast.view = customToastroot
        customtoast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0, 0)
        customtoast.duration = Toast.LENGTH_LONG

        customtoast.show()
    }

    private fun getLayout(type: Int): Int {
        return when (type) {
            WARNING -> R.layout.custom_toast_warning
            SUCCESS -> R.layout.custom_toast_success
            INFO -> R.layout.custom_toast_info
            else -> R.layout.custom_toast_error
        }
    }

}