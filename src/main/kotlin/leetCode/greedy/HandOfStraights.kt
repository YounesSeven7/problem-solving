package leetCode.greedy

import java.util.PriorityQueue

class HandOfStraights {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        if (hand.size % groupSize > 0) return false

        val map = mutableMapOf<Int, Int>()
        for (num in hand) map[num] = map.getOrDefault(num, 0) + 1

        val minHeap = PriorityQueue<Int>()
        for (num in map.keys) minHeap.add(num)

        repeat(hand.size / groupSize) {
            var start = minHeap.peek()
            var count = 0
            while (count < groupSize) {
                if (!(map.containsKey(start)) || map[start]!! < 1) return false
                map[start] = map[start]!! - 1
                count++
                start++
            }
            while (minHeap.isNotEmpty() && map[minHeap.peek()]!! == 0) minHeap.poll()
        }
        return true
    }
}