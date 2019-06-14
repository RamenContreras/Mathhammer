package chimera.mathhammer


class Calculator() {

    fun toHit(bs: Int): Double{
        val BS = bs.toDouble()

        val hit = ((7-BS)/6)
        //val reroll = ((7-BS)/36)
        val total = hit + 0 //reroll


        return total
    }
}