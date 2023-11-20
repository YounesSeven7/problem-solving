package leetCode.MathAndGeometry

class RotateImage {
    fun rotate(matrix: Array<IntArray>): Unit {
        var l = 0
        var r = matrix.size - 1
        while (l < r) {
            for (i in 0 until r - l) {
                val top = matrix[l][l + i]
                matrix[l][l + i] = matrix[r - i][l]
                matrix[r - i][l] = matrix[r][r - i]
                matrix[r][r - i] = matrix[l + i][r]
                matrix[l + i][r] = top
            }
            l++
            r--
        }
    }
}