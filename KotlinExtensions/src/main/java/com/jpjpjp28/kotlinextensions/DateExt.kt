package com.jpjpjp28.kotlinextensions

import java.text.SimpleDateFormat
import java.util.*

/**
 * Format the target string date to Date
 * with the specified date formatting.
 */
fun String.toDate(format: String): Date? = SimpleDateFormat(format, Locale.getDefault()).parse(this)

/**
 * Format the target Date to String
 * with the specified date formatting.
 */
fun Date.toString(format: String): String = SimpleDateFormat(format, Locale.getDefault()).format(this)