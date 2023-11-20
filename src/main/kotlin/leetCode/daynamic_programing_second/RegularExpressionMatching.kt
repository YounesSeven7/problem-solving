package leetCode.daynamic_programing_second

class RegularExpressionMatching {
    fun isMatch(s: String, p: String): Boolean {
        val n = s.length
        val m = p.length
        val dp = mutableMapOf<String, Boolean>()

        fun dfs(i: Int, j: Int): Boolean {
            if (i == n && j >= m) return true
            if (i > n) return false
            if (j >= m) return false
            if (dp.containsKey("$i,$j")) return dp["$i,$j"]!!

            val pCurrentChar = p[j]
            val sCurrentChar = if (i < n) s[i] else if (pCurrentChar == '.') p[j] else '.'

            val repeat = ((j + 1 < m) && (p[j + 1] == '*'))
            val nextJ = if (repeat) j + 2 else j + 1

            if (!repeat && i == n) return false

            val noOne = if (repeat) dfs(i, nextJ) else false
            val one = if (sCurrentChar == pCurrentChar) dfs(i + 1, nextJ) else false
            val more = if (repeat && sCurrentChar == pCurrentChar) dfs(i + 1, j) else false

            dp["$i,$j"] = noOne || one || more
            return dp["$i,$j"]!!
        }
        return dfs(0, 0)
    }
}