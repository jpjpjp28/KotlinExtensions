package com.jpjpjp28.kotlinextensions

import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by john.custodio on 06/24/2020.
 */

/**
 * Starts a smooth scroll using the provided {@link SmoothScroller}.
 *
 * <p>Each instance of SmoothScroller is intended to only be used once. Provide a new
 * SmoothScroller instance each time this method is called.
 *
 * <p>Calling this method will cancel any previous smooth scroll request.
 */
fun RecyclerView.smoothSnapToPosition(position: Int, snapMode: Int = LinearSmoothScroller.SNAP_TO_START) {
    val smoothScroller = object : LinearSmoothScroller(this.context) {
        override fun getVerticalSnapPreference(): Int = snapMode
        override fun getHorizontalSnapPreference(): Int = snapMode
    }
    smoothScroller.targetPosition = position
    layoutManager?.startSmoothScroll(smoothScroller)
}