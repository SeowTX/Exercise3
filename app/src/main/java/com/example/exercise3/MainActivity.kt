package com.example.exercise3

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener { calculation() }
        buttonReset.setOnClickListener { reset() }
    }

    private fun reset() {
        spinnerAge.setSelection(0)
        radioGroupGender.clearCheck()
        textViewPremium.text=getString(R.string.insurance_premium)
        checkBoxSmoker.isChecked=false
    }

    private fun calculation() {
        if(radioGroupGender.checkedRadioButtonId!=-1) {
            var age = spinnerAge.selectedItem.toString()
            var genderID = radioGroupGender.checkedRadioButtonId
            var smoker = checkBoxSmoker.isChecked
            var gender = findViewById<RadioButton>(genderID).text.toString()
            var premium = 0
            var genderFees = 0
            var smokerFees = 0
            var total = 0



            if (age.equals("Less than 17")) {
                premium = 60
                genderFees = 0
                smokerFees = 0
            } else if (age.equals("17 to 25")) {
                premium = 70
                if (gender.equals("Male")) {
                    genderFees = 50
                }
                if (smoker) {
                    smokerFees = 100
                }

            } else if (age.equals("26 to 30")) {
                premium = 90
                if (gender.equals("Male")) {
                    genderFees = 100
                }
                if (smoker) {
                    smokerFees = 150
                }

            } else if (age.equals("31 to 40")) {

                premium = 120
                if (gender.equals("Male")) {
                    genderFees = 150
                }
                if (smoker) {
                    smokerFees = 200
                }
            } else if (age.equals("41 to 55")) {
                premium = 150
                if (gender.equals("Male")) {
                    genderFees = 200
                }
                if (smoker) {
                    smokerFees = 250
                }

            } else {
                premium = 150
                if (gender.equals("Male")) {
                    genderFees = 200
                }
                if (smoker) {
                    smokerFees = 300
                }

            }
            total = premium + genderFees + smokerFees
            textViewPremium.text = getString(R.string.insurance_premium)+"\nPremium = RM "+premium+
                    "\nExtra Payment For Male = RM "+genderFees+"\nExtra Payment For Smoker = RM "+smokerFees+"\nTotal = RM "+total
        }else{
            Dialog()
        }


    }

    private fun Dialog(){
        val builder = AlertDialog.Builder(this);
        builder.setTitle("Information")
            .setMessage("Please Select Your Gender...")
            .setPositiveButton("OK",{ dialogInterface: DialogInterface, i: Int -> })

        builder.show()
    }
}