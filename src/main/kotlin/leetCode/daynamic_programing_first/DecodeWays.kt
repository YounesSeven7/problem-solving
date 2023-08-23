package leetCode.daynamic_programing_first

import javax.xml.stream.events.Characters

class DecodeWays {
    fun numDecodings(s: String): Int {
        if (s.length == 1 && s[0] == '0') return 0
        val dp = IntArray(s.length)
        fun recursion(start: Int): Int {
            if (start == s.length) return 1
            if (dp[start] != 0) return dp[start]
            if (s[start] == '0') return 0

            var res = 0
            res += recursion(start + 1)

            if (start + 1 == s.length) return res
            val code = s.subSequence(start, start + 2).toString().toInt()
            if (code > 26) return res
            res += recursion(start + 2)
            dp[start] = res
            return res
        }
        val res = recursion(0)
        print(res)
        return res
    }
}

