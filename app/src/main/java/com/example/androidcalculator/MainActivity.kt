package com.example.androidcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnThree: Button
    private lateinit var btnFour: Button
    private lateinit var btnFive: Button
    private lateinit var btnSix: Button
    private lateinit var btnSeven: Button
    private lateinit var btnEight: Button
    private lateinit var btnNine: Button
    private lateinit var btnZero: Button
    private lateinit var btnClear: Button
    private lateinit var btnEquals: Button
    private lateinit var btnAdd: Button
    private lateinit var btnSub: Button
    private lateinit var btnDivide: Button
    private lateinit var btnMultiply: Button

    private lateinit var calculationsTextView: TextView
    private lateinit var resultTextView: TextView

    private var isOperationSelected: Boolean = false

    private var valueOne by Delegates.notNull<Double>()
    private var valueTwo by Delegates.notNull<Double>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOne = findViewById(R.id.btn_one)
        btnOne.setOnClickListener(this)
        btnTwo = findViewById(R.id.btn_two)
        btnTwo.setOnClickListener(this)
        btnThree = findViewById(R.id.btn_three)
        btnThree.setOnClickListener(this)
        btnFour = findViewById(R.id.btn_four)
        btnFour.setOnClickListener(this)
        btnFive = findViewById(R.id.btn_five)
        btnFive.setOnClickListener(this)
        btnSix = findViewById(R.id.btn_six)
        btnSix.setOnClickListener(this)
        btnSeven = findViewById(R.id.btn_seven)
        btnSeven.setOnClickListener(this)
        btnEight = findViewById(R.id.btn_eight)
        btnEight.setOnClickListener(this)
        btnNine = findViewById(R.id.btn_nine)
        btnNine.setOnClickListener(this)
        btnZero = findViewById(R.id.btn_zero)
        btnZero.setOnClickListener(this)
        btnEquals = findViewById(R.id.btn_equal)
        btnEquals.setOnClickListener(this)
        btnAdd = findViewById(R.id.btn_add)
        btnAdd.setOnClickListener(this)
        btnSub = findViewById(R.id.btn_sub)
        btnSub.setOnClickListener(this)
        btnMultiply = findViewById(R.id.btn_mul)
        btnMultiply.setOnClickListener(this)
        btnDivide = findViewById(R.id.btn_div)
        btnDivide.setOnClickListener(this)
        btnClear = findViewById(R.id.btn_clear)
        btnClear.setOnClickListener(this)

        calculationsTextView = findViewById(R.id.calculations)
        resultTextView = findViewById(R.id.reslut)
    }

    override fun onClick(v: View?) {
        when (v) {
            btnOne -> displayNumbers(btnOne)
            btnTwo -> displayNumbers(btnTwo)
            btnThree -> displayNumbers(btnThree)
            btnFour -> displayNumbers(btnFour)
            btnFive -> displayNumbers(btnFive)
            btnSix -> displayNumbers(btnSix)
            btnSeven -> displayNumbers(btnSeven)
            btnEight -> displayNumbers(btnEight)
            btnNine -> displayNumbers(btnNine)
            btnZero -> displayNumbers(btnZero)
            btnAdd -> displayOperations(btnAdd)
            btnSub -> displayOperations(btnSub)
            btnMultiply -> displayOperations(btnMultiply)
            btnDivide -> displayOperations(btnDivide)
            btnEquals -> calculate()
            btnClear -> clear()
        }

    }

    /* This function takes the text of the numerical button that was pressed and appends it to the calculation Text view.
    It then calls the convertToDouble function.
     */
    private fun displayNumbers(button: Button) {
        calculationsTextView.append(button.text.toString())
        convertToDouble(button.text.toString())
    }

    // This function takes a string and cast it as Int to one of two variables depending on if an operation has been selected or not.
    private fun convertToDouble(stringValue: String) {
        if (isOperationSelected) {
            valueTwo = stringValue.toDouble()
        } else {
            valueOne = stringValue.toDouble()
        }
    }

    // This function takes a button as a parameter and appends it's text to the calculation text view.
    // It then sets the isOperationSelected Boolean value to true.
    private fun displayOperations(button: Button) {
        calculationsTextView.append(button.text.toString())
        isOperationSelected = true
    }

    // This function gets the value of the calculation text view and does a calculation based on what operation was selected by the user.
    // If none was selected a toast is shown to the user indicating as such.
    // It lastly calls the displayResults function and resets the isOperationSelected Boolean to False.
    // .
    private fun calculate() {
        var result = 0.0
        val resultAsString: String = calculationsTextView.text.toString()

        if (resultAsString.contains("+")) {
            result = valueOne + valueTwo
        } else if (resultAsString.contains("-")) {
            result = valueOne - valueTwo
        } else if (resultAsString.contains("*")) {
            result = valueOne * valueTwo
        } else if (resultAsString.contains("/")) {
            result = valueOne / valueTwo
        } else {
            Toast.makeText(this, "No operation has been selected", Toast.LENGTH_SHORT).show()
        }
        displayResult(result)

        isOperationSelected = false

    }

    // Displays the result of a calculation to the user and calls the clear function.
    private fun displayResult(myResult: Double) {
        resultTextView.text = myResult.toString()
        clear()
    }

    // This function clears the calculation text view when the clear button is pressed or when a calculation is completed.
    private fun clear() {
        calculationsTextView.text = " "
    }

}





