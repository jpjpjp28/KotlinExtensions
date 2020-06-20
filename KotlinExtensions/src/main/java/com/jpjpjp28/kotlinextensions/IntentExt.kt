package com.jpjpjp28.kotlinextensions

import android.app.Activity
import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment

/**
 * Created by john.custodio on 06/20/2020.
 */

/**
 * Start [Activity] with optional extras and optional block params (e.g. setFlags, addFlags, etc.).
 * @author John Paul Custodio
 * @param extras optional extras provided to started activity
 * @param block optional block params for intent flags
 */
inline fun <reified T : Activity> Activity.launchActivity(extras: Bundle? = null, noinline block: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    if (extras != null) intent.putExtras(extras)
    intent.block()
    startActivity(intent)
}

/**
 * Start [Activity] with optional extras.
 * @author John Paul Custodio
 * @param extras optional extras provided to started activity
 * @param activityOptions activityOptions, used in Lollipop transitions
 * @param block optional block params for intent flags
 */
inline fun <reified T : Activity> Activity.launchActivity(extras: Bundle? = null, activityOptions: ActivityOptionsCompat, noinline block: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    if (extras != null) intent.putExtras(extras)
    intent.block()
    ActivityCompat.startActivity(this, intent, activityOptions.toBundle())
}

/**
 * Start [Activity] for result with optional extras.
 * @author John Paul Custodio
 * @param requestCode code returned [Activity.onActivityResult]
 * @param extras optional extras provided to started activity
 * @param block optional block params for intent flags
 */
inline fun <reified T : Activity> Activity.launchActivityForResult(requestCode: Int, extras: Bundle? = null, noinline block: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    if (extras != null) intent.putExtras(extras)
    intent.block()
    startActivityForResult(intent, requestCode)
}

/**
 * Start [Activity] with optional extras.
 * @author John Paul Custodio
 * @param requestCode code returned [Activity.onActivityResult]
 * @param extras optional extras provided to started activity
 * @param activityOptions activityOptions, used in Lollipop transitions
 * @param block optional block params for intent flags
 */
inline fun <reified T : Activity> Activity.launchActivityForResult(requestCode: Int, extras: Bundle? = null, activityOptions: ActivityOptionsCompat, noinline block: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    if (extras != null) intent.putExtras(extras)
    intent.block()
    ActivityCompat.startActivityForResult(this, intent, requestCode, activityOptions.toBundle())
}

/**
 * Start [Activity] with optional extras and optional block params (e.g. setFlags, addFlags, etc.).
 * @author John Paul Custodio
 * @param extras optional extras provided to started activity
 * @param block optional block params for intent flags
 */
inline fun <reified T : Activity> Fragment.launchActivity(extras: Bundle? = null, noinline block: Intent.() -> Unit = {}) {
    val intent = Intent(activity, T::class.java)
    if (extras != null) intent.putExtras(extras)
    intent.block()
    startActivity(intent)
}

/**
 * Start [Activity] with optional extras and optional block params (e.g. setFlags, addFlags, etc.).
 * @author John Paul Custodio
 * @param extras optional extras provided to started activity
 * @param block optional block params for intent flags
 */
inline fun <reified T : Activity> android.app.Fragment.launchActivity(extras: Bundle? = null, noinline block: Intent.() -> Unit = {}) {
    val intent = Intent(activity, T::class.java)
    if (extras != null) intent.putExtras(extras)
    intent.block()
    startActivity(intent)
}

/**
 * Start [Activity] for result with optional extras.
 * @author John Paul Custodio
 * @param requestCode code returned [Activity.onActivityResult]
 * @param extras optional extras provided to started activity
 * @param block optional block params for intent flags
 */
inline fun <reified T : Activity> Fragment.launchActivityForResult(requestCode: Int, extras: Bundle? = null, noinline block: Intent.() -> Unit = {}) {
    val intent = Intent(activity, T::class.java)
    if (extras != null) intent.putExtras(extras)
    intent.block()
    startActivityForResult(intent, requestCode)
}

/**
 * Start [Activity] for result with optional extras.
 * @author John Paul Custodio
 * @param requestCode code returned [Activity.onActivityResult]
 * @param extras optional extras provided to started activity
 * @param block optional block params for intent flags
 */
inline fun <reified T : Activity> android.app.Fragment.launchActivityForResult(requestCode: Int, extras: Bundle? = null, noinline block: Intent.() -> Unit = {}) {
    val intent = Intent(activity, T::class.java)
    if (extras != null) intent.putExtras(extras)
    intent.block()
    startActivityForResult(intent, requestCode)
}