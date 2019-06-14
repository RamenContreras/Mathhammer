package chimera.mathhammer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
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

        bsEntry_text.addTextChangedListener(object : TextWatcher {

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
                    updateText(textview_calculate, attacker, calculator)
                }
            }
        })


        radioGroup?.setOnCheckedChangeListener { radioGroup, checkedId ->
            if (radioGroup.rerollNone_radio.id == checkedId) {
                attacker.setRR("Rerolling nothing")
                updateText(textview_calculate, attacker, calculator)
            }
            else if (radioGroup.rerollOne_radio.id == checkedId) {
                attacker.setRR("Rerolling 1's")
                updateText(textview_calculate, attacker, calculator)
            }
            else if (radioGroup.rerollMiss_radio.id == checkedId) {
                attacker.setRR("Rerolling misses")
                updateText(textview_calculate, attacker, calculator)
            }
        }

        //calculate(bsEntry_text, textview_calculate)
    }
}

fun updateText(answertext: TextView, attacker: WHUnit, calculator: Calculator){

    answertext.text = calculator.toHit(attacker.bs, attacker.reroll).toString()

}