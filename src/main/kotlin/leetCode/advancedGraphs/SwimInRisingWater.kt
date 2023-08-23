package leetCode.advancedGraphs

import java.util.PriorityQueue

class SwimInRisingWater {
    fun swimInWater(grid: Array<IntArray>): Int {
        if (grid.size == 1) return 0
        val minHeap = PriorityQueue<IntArray> { a, b -> a[0] - b[0] }
        val visited = mutableSetOf<String>()
        val n = grid.size
        val arr = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )
        var time = 0

        minHeap.add(intArrayOf(grid[0][0], 0, 0))

        while (minHeap.isNotEmpty()) {
            val (currentTime, currentRow, currentColumn) = minHeap.poll()
            if (visited.contains("$currentRow, $currentColumn")) continue

            visited.add("$currentRow, $currentColumn")
            time = maxOf(time, currentTime)
            if (currentRow == n-1 && currentColumn == n-1) return time
            for ((row, column) in arr) {
                val nextRow = currentRow + row
                val nextColumn = currentColumn + column
                if (nextRow >= n || nextColumn >= n || nextColumn < 0 || nextRow < 0 ||visited.contains("$nextRow, $nextColumn")) continue
                minHeap.add(intArrayOf(grid[nextRow][nextColumn], nextRow, nextColumn))
            }
        }
        return time
    }
}