package leetCode.greedy

class GasStation {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        if (cost.sum() > gas.sum()) return -1

        var gasInTank = 0
        var start = 0

        for (i in gas.indices) {
            if (gasInTank < 0) start = i
            gasInTank = maxOf(gasInTank + gas[i] - cost[i], gas[i] - cost[i])
        }

        return start
    }
}