package chimera.mathhammer

class WHUnit(var att: Int = 1,
             var bs: Int = 4,
             var str: Int = 4,
             var tough: Int = 4,
             var sv: Int = 4,
             var ap: Int = 0,
             var dmg: Int = 1,
             var wound: Int = 1) {

    var reroll: Int = 0

    fun setRR(string: String){
        if (string == "Rerolling nothing" )
            reroll = 0
        else if (string == "Rerolling 1's")
            reroll = 1
        else if (string == "Rerolling misses")
            reroll = bs - 1
    }
}