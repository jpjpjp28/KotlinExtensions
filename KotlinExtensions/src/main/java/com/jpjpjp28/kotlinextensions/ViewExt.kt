package com.jpjpjp28.kotlinextensions

import android.os.Build
import android.util.TypedValue
import androidx.annotation.UiThread
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

/**
 * Created by john.custodio on 06/20/2020.
 */

/**
 * Sets visibility to VISIBLE
 */
fun View.visible() {
    this.visibility = View.VISIBLE
}

/**
 * Sets visibility to GONE
 */
fun View.gone() {
    this.visibility = View.GONE
}

/**
 * Sets visibility to INVISIBLE
 */
fun View.invisible() {
    this.visibility = View.INVISIBLE
}

/**
 * Checks whether view is visible
 */
fun View.isVisible(): Boolean {
    return this.visibility == View.VISIBLE
}

/**
 * Checks whether view is visible
 */
fun View.isInvisible(): Boolean {
    return this.visibility == View.INVISIBLE
}

/**
 * Checks whether view is visible
 */
fun View.isGone(): Boolean {
    return this.visibility == View.GONE
}

/**
 * Animate the view with fade in animation.
 */
@UiThread
@JvmOverloads
fun View.fadeIn(duration: Long = 500) {
    this.clearAnimation()
    val anim = AlphaAnimation(this.alpha, 1.0f)
    anim.duration = duration
    this.startAnimation(anim)
}

/**
 * Animate the view with fade out animation.
 */
@UiThread
@JvmOverloads
fun View.fadeOut(duration: Long = 500) {
    this.clearAnimation()
    val anim = AlphaAnimation(this.alpha, 0.0f)
    anim.duration = duration
    this.startAnimation(anim)
}

/**
 * Set margins to the view.
 *
 * @receiver View
 * @param marginLeft left margin
 * @param marginTop top margin
 * @param marginRight right margin
 * @param marginBottom bottom margin
 */
fun View.setMargin(marginLeft: Int? = null, marginTop: Int? = null, marginRight: Int? = null, marginBottom: Int? = null) {
    val params = layoutParams as ViewGroup.MarginLayoutParams
    params.setMargins(marginLeft ?: params.leftMargin,
        marginTop ?: params.topMargin,
        marginRight ?: params.rightMargin,
        marginBottom ?: params.bottomMargin)
    this.layoutParams = params
}

/**
 * Add [?selectableItemBackground] programmatically to [View] as ripple effect.
 */
fun View.addRipple() = with(TypedValue()) {
    context.theme.resolveAttribute(android.R.attr.selectableItemBackground, this, true)
    setBackgroundResource(resourceId)
}

/**
 * Add [?selectableItemBackgroundBorderless] programmatically to [View] as circle ripple effect.
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun View.addCircleRipple() = with(TypedValue()) {
    context.theme.resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, this, true)
    setBackgroundResource(resourceId)
}

/**
 * Show a Snackbar with [messageRes], execute [block] and show it
 */
inline fun View.snack(@StringRes messageRes: Int, @BaseTransientBottomBar.Duration length: Int = Snackbar.LENGTH_LONG, block: Snackbar.() -> Unit) {
    snack(resources.getString(messageRes), length, block)
}

/**
 * Show a Snackbar with [message], execute [block] and show it
 */
inline fun View.snack(message: String, @BaseTransientBottomBar.Duration length: Int = Snackbar.LENGTH_LONG, block: Snackbar.() -> Unit) {
    val snack = Snackbar.make(this, message, length)
    snack.block()
    snack.show()
}

/**
 * Add action to the Snackbar, change action color using [color].
 */
fun Snackbar.action(@StringRes actionRes: Int, color: Int? = null, listener: (View) -> Unit) {
    action(view.resources.getString(actionRes), color, listener)
}

/**
 * Add action to the Snackbar, change action color using [color].
 */
fun Snackbar.action(action: String, color: Int? = null, listener: (View) -> Unit) {
    setAction(action, listener)
    color?.let { setActionTextColor(color) }
}