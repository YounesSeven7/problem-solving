package leetCode.hard

class LongestHappyPrefix {
    fun longestPrefix(s: String): String {
        val lps = IntArray(s.length)
        var i = 1
        var j = 0
        while (i < s.length) {
            if(s[i] == s[j]) {
                j++
                lps[i] = j
                i++
            } else if (j > 0) {
                j = lps[j-1]
            } else {
                lps[i] = j
                i++
            }
        }
        return s.substring(0, lps[i-1])
    }
}