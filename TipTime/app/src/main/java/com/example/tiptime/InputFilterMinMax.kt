package com.example.tiptime

import android.text.InputFilter
import android.text.Spanned


class InputFilterMinMax(min: Double, max: Double) : InputFilter {
    private var min: Double = min
    private var max: Double = max

    override fun filter(
        source: CharSequence,
        start: Int,
        end: Int,
        dest: Spanned,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        try {
            val input = (dest.toString() + source.toString()).toDouble()
            if (isInRange(min, max, input)) return null
        } catch (nfe: NumberFormatException) {
        }
        return ""
    }

    private fun isInRange(min: Double, max: Double, x: Double): Boolean {
        return x in min..max
    }
}