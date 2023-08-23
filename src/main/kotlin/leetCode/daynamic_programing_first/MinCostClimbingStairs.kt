package leetCode.daynamic_programing_first

class MinCostClimbingStairs {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val size = cost.size
        val arr = IntArray(size){-1}
        fun getMinCost(i: Int): Int{
            if (i == size - 1) return cost[i]

            val smallStep = if (arr[i+1] != -1) arr[i+1] else getMinCost(i+1)
            val bigStep = if (i+2 == size) 0 else if (arr[i+2] != -1) arr[i+2]
            else getMinCost(i+2)
            val min = Math.min(smallStep, bigStep)
            arr[i] = min + cost[i]
            return arr[i]

        }
        return Math.min(getMinCost(0), getMinCost(1))
    }


}