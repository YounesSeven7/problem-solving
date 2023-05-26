package leetCode.graphs

import java.util.LinkedList
import java.util.PriorityQueue
import kotlin.math.min

class RottingOranges {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue = LinkedList<Int>()
        var minutes = 0

        for (r in grid.indices)
            for (c in grid[0].indices)
                if (grid[r][c] == 2) queue.add(r*10+c)



        while (queue.isNotEmpty()) {
            minutes++
            repeat(queue.size) {
                print(queue)
                val r = queue.first() / 10
                val c = queue.remove() % 10

                makeRottingOranges(r, c + 1, queue, grid)
                makeRottingOranges(r, c - 1, queue, grid)
                makeRottingOranges(r + 1, c, queue, grid)
                makeRottingOranges(r - 1, c, queue, grid)
            }
        }

        for (r in grid.indices)
            for (c in grid[0].indices)
                if (grid[r][c] == 1) return -1


        return if (minutes == 0) return 0 else minutes - 1
    }

    fun makeRottingOranges(r: Int, c: Int, queue: LinkedList<Int>, grid: Array<IntArray>) {
        if (r !in grid.indices || c !in grid[0].indices || grid[r][c] != 1) return
        queue.add(r*10+c)
        grid[r][c] = 2
    }


}