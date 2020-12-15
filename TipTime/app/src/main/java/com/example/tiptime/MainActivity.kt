package com.example.tiptime

import android.content.Context
import android.os.Bundle
import android.text.InputFilter
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*
import kotlin.math.ceil


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var hkLocale: Locale = Locale("en", "HK")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.costOfServiceEditText.filters =
            arrayOf<InputFilter>(InputFilterMinMax(0.0, 1000000.0), InputFilter.LengthFilter(10))
        bindListenersToViews()

        displayTip(0.0)
    }

    private fun bindListenersToViews() {

        binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(view, keyCode)
            calculateTip()
            return@setOnKeyListener false
        }

        binding.tipOptions.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { _, _ ->
            calculateTip()
        })
        binding.roundUpSwitch.setOnClickListener { calculateTip() }
        binding.calculateButton.setOnClickListener { calculateTip() }


    }

    private fun displayTip(tip: Double) {
        val formattedTip: String = NumberFormat.getCurrencyInstance(hkLocale).format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }

    private fun calculateTip() {
        val stringInTextField: String = binding.costOfServiceEditText.text.toString()
        val cost: Double? = stringInTextField.toDoubleOrNull()

        if (cost == null) {
            displayTip(0.0)
            return
        }

        val tipPercentage: Double = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip: Double = tipPercentage * cost
        tip = if (binding.roundUpSwitch.isChecked) ceil(tip) else tip

        displayTip(tip)
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}