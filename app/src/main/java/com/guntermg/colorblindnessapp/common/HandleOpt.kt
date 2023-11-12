package com.guntermg.colorblindnessapp.common


fun String?.handleOpt() = this ?: ""

/**
Returns itself or 0 in case of being null
 */
fun Int?.handleOpt() = this ?: 0

/**
Returns itself or false in case of being null
 */
fun Boolean?.handleOpt() = this ?: false

/**
Returns itself or an empty list in case of being null
 */
fun <T> List<T>?.handleOpt() = this ?: listOf()