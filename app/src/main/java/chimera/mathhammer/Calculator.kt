package chimera.mathhammer


class Calculator() {

    var hitting = 0.5
    var wounding = 0.5
    var saving = 0.5
    var shrugOff = 0.5

    fun toHit(bs: Int, rr: Int): Double {
        val BS = bs.toDouble()

        val hit = ((7-BS)/6)
        val reroll = ((7-BS)/36)
        val total = hit + (rr*reroll)
        hitting = total

        return total
    }

    fun toWound(str: Int, tou: Int, rr: Int): Double {
        val STR = str.toDouble()
        val TOU = tou.toDouble()

        var toWound = 4.0

        if (STR >= (TOU*2))
            toWound = 2.0
        else if (STR > TOU)
            toWound = 3.0
        else if (STR == TOU)
            toWound = 4.0
        else if (STR <= (TOU/2))
            toWound = 6.0
        else if (STR < TOU)
            toWound = 5.0


        val reroll = (7-toWound)/36
        val total = ((7-toWound)/6) + (rr*reroll)
        wounding = total

        return total
    }

    fun toSave(sv: Int, isv: Int, ap: Int): Double {
        val SV = sv.toDouble()
        val ISV = isv.toDouble()
        val AP = ap.toDouble()

        var notSave = 0.5

        if (ISV != 0.0 && (SV+AP >= ISV))
            notSave = ISV
        else if ((SV + AP) >= 7.0)
            notSave = 7.0
        else
            notSave = (SV+AP)

        val total = (notSave-1)/6
        saving = total


        return total
    }

    fun toFNP(fnp: Int): Double{
        val FNP = fnp.toDouble()

        val toFNP = ((FNP-1)/6)
        var total = toFNP
        if (toFNP > 1.0){
            total = 1.0
        }
        else if (toFNP < 0)
        {
            total = 0.0
        }
        shrugOff = total

        return total
    }

}