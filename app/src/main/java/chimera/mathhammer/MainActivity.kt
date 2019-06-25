package chimera.mathhammer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    val attacker = WHUnit()
    val defender = WHUnit()

    val calculator = Calculator()

    var attack_choices = arrayOf("1", "2", "3", "4", "5", "6", "1d3", "1d6")




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bsEntry_text.setText(attacker.bs.toString())
        strEntry_text.setText(attacker.str.toString())
        touEntry_text.setText(defender.tough.toString())
        apEntry_text.setText(attacker.ap.toString())
        svEntry_text.setText(defender.sv.toString())
        isvEntry_text.setText(defender.isv.toString())
        fnpEntry_text.setText(defender.fnp.toString())
        toHit_radioGroup.rerollHitNone_radio.isChecked = true
        toWound_radioGroup.rerollWoundNone_radio.isChecked = true

        //Adapter for spinner
        attacks_spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, attack_choices)

        //item selected listener for spinner
        attacks_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?){
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (attack_choices[p2]){
                    "1" -> { attacker.att = 1.0
                        updateTextSubFour(expected_textView, attacker, defender, calculator)}
                    "2" -> { attacker.att = 2.0
                        updateTextSubFour(expected_textView, attacker, defender, calculator)}
                    "3" -> { attacker.att = 3.0
                        updateTextSubFour(expected_textView, attacker, defender, calculator)}
                    "4" -> { attacker.att = 4.0
                        updateTextSubFour(expected_textView, attacker, defender, calculator)}
                    "5" -> { attacker.att = 5.0
                        updateTextSubFour(expected_textView, attacker, defender, calculator)}
                    "6" -> { attacker.att = 6.0
                        updateTextSubFour(expected_textView, attacker, defender, calculator)}
                    "1d3" -> { attacker.att = 2.0
                        updateTextSubFour(expected_textView, attacker, defender, calculator)}
                    "1d6" -> { attacker.att = 3.5
                        updateTextSubFour(expected_textView, attacker, defender, calculator)}
                    else -> Toast.makeText(this@MainActivity, "error", LENGTH_LONG).show()
                }
            }
        }


        bsEntry_text.addTextChangedListener(object : TextWatcher {          //checking BS change

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (bsEntry_text.text.isEmpty()) {
                }
                else {
                    attacker.bs = s.toString().toInt()
                    updateText(toHit_textView, attacker, calculator)
                    updateTextSubThree(total_textView, attacker, defender, calculator)
                }
            }
        })

        strEntry_text.addTextChangedListener(object : TextWatcher {          //checking Str change

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (strEntry_text.text.isEmpty()) {
                }
                else {
                    attacker.str = s.toString().toInt()
                    updateTextSub(toWound_textView, attacker, defender, calculator)
                    updateTextSubThree(total_textView, attacker, defender, calculator)
                }
            }
        })

        touEntry_text.addTextChangedListener(object : TextWatcher {          //checking Tough change

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (touEntry_text.text.isEmpty()) {
                }
                else {
                    defender.tough = s.toString().toInt()
                    updateTextSub(toWound_textView, attacker, defender, calculator)
                    updateTextSubThree(total_textView, attacker, defender, calculator)
                }
            }
        })

        apEntry_text.addTextChangedListener(object : TextWatcher {          //checking AP change

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (apEntry_text.text.isEmpty()) {
                }
                else {
                    attacker.ap = s.toString().toInt()
                    updateTextSubTwo(toSave_textView, attacker, defender, calculator)
                    updateTextSubThree(total_textView, attacker, defender, calculator)
                }
            }
        })

        svEntry_text.addTextChangedListener(object : TextWatcher {          //checking sv change

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (svEntry_text.text.isEmpty()) {
                }
                else {
                    defender.sv = s.toString().toInt()
                    updateTextSubTwo(toSave_textView, attacker, defender, calculator)
                    updateTextSubThree(total_textView, attacker, defender, calculator)
                }
            }
        })

        isvEntry_text.addTextChangedListener(object : TextWatcher {          //checking isv change

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (isvEntry_text.text.isEmpty()) {
                }
                else {
                    defender.isv = s.toString().toInt()
                    updateTextSubTwo(toSave_textView, attacker, defender, calculator)
                    updateTextSubThree(total_textView, attacker, defender, calculator)
                }
            }
        })

        fnpEntry_text.addTextChangedListener(object : TextWatcher {          //checking fnp change

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (fnpEntry_text.text.isEmpty()) {
                }
                else {
                    defender.fnp = s.toString().toInt()
                    updateTextSubTwoB(toFNP_textView, attacker, defender, calculator)
                    updateTextSubThree(total_textView, attacker, defender, calculator)
                }
            }
        })


        toHit_radioGroup?.setOnCheckedChangeListener { radioGroup, checkedId ->
            if (radioGroup.rerollHitNone_radio.id == checkedId) {
                attacker.setHRR("Rerolling nothing")
                updateText(toHit_textView, attacker, calculator)
                updateTextSubThree(total_textView, attacker, defender, calculator)
            } else if (radioGroup.rerollHitOne_radio.id == checkedId) {
                attacker.setHRR("Rerolling 1's")
                updateText(toHit_textView, attacker, calculator)
                updateTextSubThree(total_textView, attacker, defender, calculator)
            } else if (radioGroup.rerollHitMiss_radio.id == checkedId) {
                attacker.setHRR("Rerolling misses")
                updateText(toHit_textView, attacker, calculator)
                updateTextSubThree(total_textView, attacker, defender, calculator)
            }
        }

        toWound_radioGroup?.setOnCheckedChangeListener { radioGroup, checkedId ->
            if (radioGroup.rerollWoundNone_radio.id == checkedId) {
                attacker.setWRR("Rerolling nothing", defender.tough)
                updateTextSubThree(total_textView, attacker, defender, calculator)
                updateTextSub(toWound_textView, attacker, defender, calculator)
            } else if (radioGroup.rerollWoundOne_radio.id == checkedId) {
                attacker.setWRR("Rerolling 1's", defender.tough)
                updateTextSub(toWound_textView, attacker, defender, calculator)
                updateTextSubThree(total_textView, attacker, defender, calculator)
            } else if (radioGroup.rerollWoundMiss_radio.id == checkedId) {
                attacker.setWRR("Rerolling misses", defender.tough)
                updateTextSub(toWound_textView, attacker, defender, calculator)
                updateTextSubThree(total_textView, attacker, defender, calculator)
            }
        }
    }
}

fun updateText(answertext: TextView, attacker: WHUnit, calculator: Calculator){

    answertext.text = "%.2f".format(calculator.toHit(attacker.bs, attacker.hreroll)*100)+"% chance to hit"

}

fun updateTextSub(answertext: TextView, attacker: WHUnit, defender: WHUnit, calculator: Calculator){          //temporary

    answertext.text = "%.2f".format(calculator.toWound(attacker.str, defender.tough, attacker.wreroll)*100)+"% chance to wound"

}

fun updateTextSubTwo(answertext: TextView, attacker: WHUnit, defender: WHUnit, calculator: Calculator){          //temporary

    answertext.text = "%.2f".format((calculator.toSave(defender.sv, defender.isv, attacker.ap)*100))+"% chance to make it through saving throw"

}

fun updateTextSubTwoB(answertext: TextView, attacker: WHUnit, defender: WHUnit, calculator: Calculator){          //temporary

    answertext.text = "%.2f".format((calculator.toFNP(defender.fnp)*100))+"% chance to make it through feel no pain"

}

fun updateTextSubThree(answertext: TextView, attacker: WHUnit, defender: WHUnit, calculator: Calculator){          //temporary

    answertext.text = "%.2f".format(((calculator.hitting * calculator.wounding * calculator.saving) * calculator.shrugOff *100))+"% chance to do damage"

}

fun updateTextSubFour(answertext: TextView, attacker: WHUnit, defender: WHUnit, calculator: Calculator){
    answertext.text = "%.2f".format(((attacker.att * calculator.hitting * calculator.wounding * calculator.saving) * calculator.shrugOff))+" expected damage"
}