package leetCode.MathAndGeometry

class SetMatrixZeroes {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        val m = matrix[0].size

        var firstRow = false
        var firsColumn = false

        for (i in 0 until n)
            if (matrix[i][0] == 0) {
                firsColumn = true
                break
            }

        for (j in 0 until m)
            if (matrix[0][j] == 0) {
                firstRow = true
                break
            }

        for (i in 1 until n)
            for (j in 1 until m)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }

        fun setRowZeroes(i: Int) {
            for (j in 0 until m)
                matrix[i][j] = 0
        }

        fun setColumnZeroes(j: Int) {
            for (i in 0 until n)
                matrix[i][j] = 0
        }

        for (i in 1 until n)
            if (matrix[i][0] == 0)
                setRowZeroes(i)

        for (j in 1 until m)
            if (matrix[0][j] == 0)
                setColumnZeroes(j)

        if (firstRow) setRowZeroes(0)
        if (firsColumn) setColumnZeroes(0)
    }
}