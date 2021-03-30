package com.project.lab1.feed.extensions

import android.animation.TimeInterpolator
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator


fun View.fadeIn(duration: Long = 300, interpolator: TimeInterpolator = DecelerateInterpolator()) {
    alpha = 0.0f
    visibility = View.VISIBLE
    animate()
            .setInterpolator(interpolator)
            .alpha(1.0f)
            .setDuration(duration)
            .start()
}

fun View.fadeOut(duration: Long = 300) {
    if(visibility != View.VISIBLE) { return }

    animate()
            .setInterpolator(AccelerateInterpolator())
            .alpha(0.0f)
            .withEndAction(Runnable {
                visibility = View.GONE
                alpha = 1.0f
            })
            .setDuration(duration)
            .start()
}