package leetCode.MathAndGeometry

class SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var l = 0
        var r = matrix[0].size - 1
        var t = 0
        var b = matrix.size - 1
        val list = ArrayList<Int>()
        while (l <= r && t <= b) {
            for (column in l..r) list.add(matrix[t][column])
            t++

            for (row in t..b) list.add(matrix[row][r])
            r--

            if (t > b || l > r) break

            for (column in r downTo l) list.add(matrix[b][column])
            b--

            for (row in b downTo t) list.add(matrix[row][l])
            l++
        }
        return list
    }
}