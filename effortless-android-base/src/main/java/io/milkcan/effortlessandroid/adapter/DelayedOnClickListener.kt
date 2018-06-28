package io.milkcan.effortlessandroid.adapter

import android.os.SystemClock
import android.view.View

/**
 * @author Eric Bachhuber (bachhuberdesign@gmail.com)
 * @version 1.1.0
 * @since 1.1.0
 */
abstract class DelayedOnClickListener(private val delayMilliseconds: Int) : View.OnClickListener {

    private var lastClickTime: Long = 0

    override fun onClick(view: View) {
        val currentClickTime = SystemClock.elapsedRealtime()

        val elapsedTime = currentClickTime - lastClickTime
        lastClickTime = currentClickTime

        when {
            elapsedTime <= delayMilliseconds -> return
            else -> onSingleClick(view)
        }
    }

    abstract fun onSingleClick(view: View)

}