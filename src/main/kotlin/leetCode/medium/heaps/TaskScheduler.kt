package leetCode.medium.heaps

import java.util.PriorityQueue
import kotlin.math.max

class TaskScheduler {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        if (n == 0) return tasks.size
        val maxHeap = PriorityQueue<Int>{a, b -> b-a}

        val map = mutableMapOf<Char, Int>()
        for (task in tasks)
            map[task] = (map[task] ?: 0) + 1
        for (value in map.values)
            maxHeap.add(value)

        val queue = ArrayDeque<IntArray>()

        var time = 0
        while (maxHeap.isNotEmpty() || queue.isNotEmpty()) {
            val elementCount = if (maxHeap.size > 0) maxHeap.remove() else 0
            time++
            if (elementCount-1 > 0) queue.add(intArrayOf(elementCount-1, time+n))
            if (queue.isNotEmpty() && queue.first()[1] == time) maxHeap.add(queue.removeFirst()[0])
        }
        print(time)
        return time
    }




}