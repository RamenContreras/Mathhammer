package chimera.mathhammer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bsEntry_text.setText("4")

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
                    calculate(bsEntry_text, textview_calculate)
                }
            }
        })


        radioGroup?.setOnCheckedChangeListener { group, checkedId ->
            if (R.id.rerollNone_radio == checkedId)
                Toast.makeText(applicationContext, "No Rerolls", Toast.LENGTH_SHORT).show()
            else if (R.id.rerollOne_radio == checkedId)
                Toast.makeText(applicationContext, "Rerolling 1's", Toast.LENGTH_SHORT).show()
            else Toast.makeText(applicationContext, "Rerolling misses", Toast.LENGTH_SHORT).show()
        }

        //calculate(bsEntry_text, textview_calculate)
    }
}

/*fun updateText(answertext: TextView){

}*/

fun calculate(bs: EditText, answertext: TextView){
    answertext.text = toHit(bs).toString()
}

fun toHit(bs: EditText): Double{
    val BS = bs.text.toString().toDouble()

    val hit = ((7-BS)/6)
    val reroll = ((7-BS)/36)
    val total = hit + 0 //reroll

    return total
}