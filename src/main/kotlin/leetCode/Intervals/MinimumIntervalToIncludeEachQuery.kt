package leetCode.Intervals

import java.util.PriorityQueue

class MinimumIntervalToIncludeEachQuery {
    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
        intervals.sortBy { it.first() }
        val queriesMinHeap = PriorityQueue<Int>{a, b -> queries[a] - queries[b]}
        val minHeap = PriorityQueue<IntArray> { a, b -> a.first() - b.first() }
        for (i in queries.indices) queriesMinHeap.add(i)
        var i = 0

        while (queriesMinHeap.isNotEmpty()) {
            val currentQueryIndex = queriesMinHeap.poll()
            while (i < intervals.size) {
                val (x, y) = intervals[i]
                if (queries[currentQueryIndex] in x..y)
                    minHeap.add(intArrayOf(y - x + 1, y))
                if (x > queries[currentQueryIndex]) break
                i++
            }
            while (minHeap.isNotEmpty() && minHeap.peek().last() < queries[currentQueryIndex])
                minHeap.poll()
            queries[currentQueryIndex] = if (minHeap.isNotEmpty()) minHeap.peek().first() else -1
        }

        return queries
    }
}