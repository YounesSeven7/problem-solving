package leetCode.Intervals

class NonOverlappingIntervals {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[0] }
        var previousY = intervals[0][1]
        var remove = 0

        for (i in 1 until intervals.size) {
            val current = intervals[i]
            val (x, y) = current
            previousY = if (x >= previousY)
                y
            else {
                remove++
                minOf(y, previousY)
            }
        }
        return remove
    }
}