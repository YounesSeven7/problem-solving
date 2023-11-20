package leetCode.Intervals

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it.first() }
        val arr = ArrayList<IntArray>()
        var previous = intervals[0]
        var i = 1
        while (i < intervals.size) {
            val current = intervals[i]
            val (x, y) = current
            val previousRange = previous[0]..previous[1]
            i++
            if (x in previousRange) {
                if (y in previousRange) continue
                else previous[1] = y
            } else {
                arr.add(previous)
                previous = current
            }

        }
        if (i == intervals.indices.last) arr.add(previous)
        return arr.toTypedArray()
    }
}