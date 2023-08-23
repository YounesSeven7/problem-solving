package leetCode.binarySearch

class SearchA2DMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val n = matrix.size
        val m = matrix[0].size
        var l = 0
        var r = n - 1

        while (l <= r) {
            val med = (l + r) / 2
            val min = matrix[med][0]
            val max = matrix[med][m - 1]

            if (target in min..max) return matrix[med].binarySearch(target) >= 0
            else if (target > max) l = med + 1
            else r = med - 1
        }
        return false
    }
}