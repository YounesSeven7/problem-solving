package leetCode.stack

import java.util.Stack

class CarFleet {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        if (position.size == 1) return 1

        val arr = Array(position.size) { i -> Pair(position[i].toDouble(), speed[i].toDouble()) }
        arr.sortWith(compareBy {it.first})

        var fleetCount = position.size
        var headFleetTime = (target - arr[arr.lastIndex].first) / arr[arr.lastIndex].second

        var stack = Stack<Pair<Double, Double>>()

        for (i in 0 until arr.size-1) stack.push(arr[i])

        while (stack.isNotEmpty()) {
            val currentCarTime = (target - stack.peek().first) / stack.peek().second
            if (currentCarTime <= headFleetTime) {
                fleetCount--
            } else {
                headFleetTime = currentCarTime
            }
            stack.pop()
        }
        return fleetCount
    }


    fun carFleetSecond(target: Int, position: IntArray, speed: IntArray): Int {
        val sortedPairs = position
            .zip(speed)
            .sortedBy { (position, _) -> position }
        var numberOfFleets = 1
        var timeRequiredForCarInFrontToReachInTarget =
            (target - sortedPairs[sortedPairs.lastIndex].first) / sortedPairs[sortedPairs.lastIndex].second.toFloat()
        var timeRequiredForCurrentCarToReachTarget: Float
        for (i in (sortedPairs.lastIndex - 1) downTo 0) {
            timeRequiredForCurrentCarToReachTarget = (target - sortedPairs[i].first) / sortedPairs[i].second.toFloat()
            if (timeRequiredForCurrentCarToReachTarget > timeRequiredForCarInFrontToReachInTarget) {
                // the current car requires more time to reach the destination
                // than the car in front of it.
                numberOfFleets++
                timeRequiredForCarInFrontToReachInTarget = timeRequiredForCurrentCarToReachTarget
            }
        }
        print(numberOfFleets)
        return numberOfFleets
    }
}