package leetCode.advancedGraphs

import kotlin.math.min

class CheapestFlightsWithinKStops {

    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        var cost = IntArray(n) { 1000000 }
        cost[src] = 0
        for (i in 0..k) {
            val temp = cost.clone()
            for ((from, to, price) in flights) {
                if (temp[from] != 1000000) {
                    temp[to] = minOf(temp[to], cost[from] + price)
                }
            }
            cost = temp
        }
        return if (cost[dst] == 1000000) -1 else cost[dst]
    }
}