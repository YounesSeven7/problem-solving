package leetCode.Intervals

class InsertInterval {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val arr = ArrayList<IntArray>()
        var add = false

        for (i in intervals.indices) {
            val currentIntervals = intervals[i]
            val (x, y) = currentIntervals

            if (x > newInterval[1]) {
                if (!add){
                    arr.add(newInterval)
                    add = true
                }
                arr.add(currentIntervals)
            }
            if (y < newInterval[0]) arr.add(currentIntervals)

            if (newInterval[0] in x..y) newInterval[0] = x
            if (newInterval[1] in x..y) newInterval[1] = y
        }

        if (!add) arr.add(newInterval)

        return arr.toTypedArray()
    }
}