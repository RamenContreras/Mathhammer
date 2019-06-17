package chimera.mathhammer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    val attacker = WHUnit()
    val defender = WHUnit(2)

    val calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bsEntry_text.setText(attacker.bs.toString())
        strEntry_text.setText(attacker.str.toString())

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

    answertext.text = calculator.toHit(attacker.bs, attacker.reroll).toString()

}

fun updateTextSub(answertext: TextView, attacker: WHUnit, defender: WHUnit, calculator: Calculator){          //temporary

    answertext.text = calculator.toWound(attacker.str, defender.tough, attacker.reroll).toString()

}

fun updateTextSubTwo(answertext: TextView, attacker: WHUnit, defender: WHUnit, calculator: Calculator){          //temporary

    answertext.text = calculator.toSave(defender.sv, defender.isv, attacker.ap).toString()

}

fun updateTextSubThree(answertext: TextView, attacker: WHUnit, defender: WHUnit, calculator: Calculator){          //temporary

    answertext.text = (calculator.hitting * calculator.wounding * calculator.saving).toString()

}