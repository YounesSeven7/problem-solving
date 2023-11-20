package leetCode.heaps

import java.util.PriorityQueue

class KClosestPointsToOrigin {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val kClosestPoints = Array(k) {intArrayOf(0, 0) }
        val priorityQueue = PriorityQueue<Pair<Int, Int>> {a,b -> a.second - b.second}
        var index = 0
        for ((x, y)in points) {
            val distance = Math.pow(x.toDouble(), 2.0) + Math.pow(y.toDouble(), 2.0)
            priorityQueue.add(Pair(index, distance.toInt()))
            index++
        }

        repeat(k) {i->
            kClosestPoints[i] = points[priorityQueue.remove().first]
        }
        return kClosestPoints
    }
}