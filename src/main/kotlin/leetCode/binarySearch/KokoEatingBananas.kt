package leetCode.binarySearch

class KokoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        val max = piles.max()!!
        if (piles.size == h) return max
        var l = 1
        var r = max
        var minHours = max
        while (l <= r) {
            val med = (l + r)/ 2
            if (med == 1) {
                l = l
            }
            var hours:Long = 0
            for (pile in piles)
                hours += Math.ceil(pile / med.toDouble()).toLong()

            if (hours > h) {
                l = med + 1
            } else {
                minHours = minOf(minHours, med)
                r = med - 1
            }
        }
        return minHours
    }
}