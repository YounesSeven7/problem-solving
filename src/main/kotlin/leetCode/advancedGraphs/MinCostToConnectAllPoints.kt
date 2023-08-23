package leetCode.advancedGraphs

import java.util.PriorityQueue
import kotlin.math.min

class MinCostToConnectAllPoints {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val set = mutableSetOf<Int>()
        val minHeap = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }
        var cost = 0
        minHeap.add(Pair(0, 0))

        while (set.size < points.size) {
            val (currentPoint, currentCost) = minHeap.poll()
            if (set.contains(currentPoint)) continue
            set.add(currentPoint)
            cost += currentCost

            for (i in points.indices) {
                val (nextX, nextY) = points[i]
                val (currentX, currentY) = points[currentPoint]
                val distance = Math.abs(currentX - nextX) + Math.abs(currentY - nextY)
                minHeap.add(Pair(i, distance))
            }

        }
        return cost
    }


}