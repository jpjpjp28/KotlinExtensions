package com.jpjpjp28.kotlinextensions

import android.os.Build
import android.text.Html
import android.text.Spanned

/**
 * Created by john.custodio on 06/20/2020.
 */

/**
 * Extension method to check if String is Number.
 */
fun String.isNumeric(): Boolean {
    val p = "^[0-9]+$".toRegex()
    return matches(p)
}

/**
 * Format a String value of integer to number with comma
 * and return a String value of it. (e.g. Target: "2000", return "2,000")
 */
fun String.formatCommaInNumberString(): String {
    return if (this.isNumeric()) {
        String.format("%,d", this.toInt())
    } else {
        this
    }
}

/**
 * Returns displayable styled text from the provided HTML string. Any &lt;img&gt; tags in the
 * HTML will display as a generic replacement image which your program can then go through and
 * replace with real images.
 *
 * <p>This uses TagSoup to handle real HTML, including all of the brokenness found in the wild.
 *
 * @receiver String to be converted into spanned HTML String
 * @return Spanned HTML String
 */
fun String.htmlAsSpanned(): Spanned = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
    Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
} else {
    @Suppress("DEPRECATION")
    Html.fromHtml(this)
}