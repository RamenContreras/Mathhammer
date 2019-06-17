package chimera.mathhammer

class WHUnit(var att: Int = 1,
             var bs: Int = 4,
             var str: Int = 4,
             var tough: Int = 4,
             var sv: Int = 4,       //save
             var isv: Int = 0,       //invulnerable save
             var ap: Int = 0,
             var dmg: Int = 1,
             var wound: Int = 1) {

    var reroll: Int = 0

    fun setHRR(string: String){
        if (string == "Rerolling nothing" )
            reroll = 0
        else if (string == "Rerolling 1's")
            reroll = 1
        else if (string == "Rerolling misses")
            reroll = bs - 1
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
            reroll = 0
        else if (string == "Rerolling 1's")
            reroll = 1
        else if (string == "Rerolling misses")
            reroll = rr-1
    }
}