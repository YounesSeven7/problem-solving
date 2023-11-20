package leetCode.MathAndGeometry

class DetectSquares {
    val map = mutableMapOf<Pair<Int, Int>, Int>()

    fun add(point: IntArray) {
        val (x, y) = point
        map[Pair(x, y)] = map.getOrDefault(Pair(x, y), 0) + 1
    }

    fun count(point: IntArray): Int {
        val (px, py) = point
        var result = 0
        for ((x, y) in map.keys) {
            if (px != x && py != y && Math.abs(px - x) == Math.abs(py - y))
                result += map.getOrDefault(Pair(x, y), 0) *
                    map.getOrDefault(Pair(px, y), 0) * map.getOrDefault(Pair(x, py), 0)
        }
       return result
    }
}