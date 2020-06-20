package com.jpjpjp28.kotlinextensions

import android.os.Build

/**
 * Created by john.custodio on 06/20/2020.
 */

/**
 * Extension method to check is aboveApi with an option to run a block of code.
 */
inline fun aboveApi(api: Int, included: Boolean = false, block: () -> Unit) {
    if (Build.VERSION.SDK_INT > if (included) api - 1 else api) {
        block()
    }
}

/**
 * Extension method to check is belowApi with an option to run a block of code.
 */
inline fun belowApi(api: Int, included: Boolean = false, block: () -> Unit) {
    if (Build.VERSION.SDK_INT < if (included) api + 1 else api) {
        block()
    }
}

/**
 * Extension method to check is aboveApi.
 */
fun isAboveApi(api: Int, included: Boolean = false): Boolean {
    return (Build.VERSION.SDK_INT > if (included) api - 1 else api)
}

/**
 * Extension method to check is belowApi.
 */
fun isBelowApi(api: Int, included: Boolean = false): Boolean {
    return (Build.VERSION.SDK_INT < if (included) api + 1 else api)
}