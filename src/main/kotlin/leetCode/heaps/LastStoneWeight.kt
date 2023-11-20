package leetCode.heaps

import java.util.PriorityQueue

class LastStoneWeight {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>{a, b -> b-a}

        for (element in stones)
            maxHeap.add(element)

        while (maxHeap.size > 1) {
            val y = maxHeap.remove()
            val x = maxHeap.peek()
            maxHeap.remove()
            if (y > x)
                maxHeap.add(y - x)
        }
        return if (maxHeap.size == 1) maxHeap.peek() else 0
    }
}