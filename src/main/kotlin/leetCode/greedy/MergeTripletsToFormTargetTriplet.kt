package leetCode.greedy

class MergeTripletsToFormTargetTriplet {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        val match = BooleanArray(3)

        for ((x, y, z) in triplets) {
            if (x > target[0] || y > target[1] || z > target[2]) continue
            for (j in target.indices) match[j] = match[j] || x == target[j]
        }

        return  match.all{ it }
    }
}