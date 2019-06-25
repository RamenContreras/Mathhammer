package chimera.mathhammer

class WHUnit(var att: Double = 1.0,
             var bs: Int = 4,
             var str: Int = 4,
             var tough: Int = 4,
             var sv: Int = 3,       //save
             var isv: Int = 0,       //invulnerable save
             var fnp: Int = 7,      //feel no pain
             var ap: Int = 0,
             var dmg: Int = 1,
             var wound: Int = 1) {

    var hreroll: Int = 0        //hit reroll
    var wreroll: Int = 0        //wound reroll

    fun setHRR(string: String){
        if (string == "Rerolling nothing" )
            hreroll = 0
        else if (string == "Rerolling 1's")
            hreroll = 1
        else if (string == "Rerolling misses")
            hreroll = bs - 1
    }

    fun setWRR(string: String, tou: Int){           //well this probably needs to be in Calculator
                                                            //this is all a mess

        var rr = 1
        if (str >= (tou*2))
            rr = 2
        else if (str > tou)
            rr = 3
        else if (str == tou)
            rr = 4
        else if (str <= (tou/2))
            rr = 6
        else if (str < tou)
            rr = 5

        if (string == "Rerolling nothing" )
            wreroll = 0
        else if (string == "Rerolling 1's")
            wreroll = 1
        else if (string == "Rerolling misses")
            wreroll = rr-1
    }
}