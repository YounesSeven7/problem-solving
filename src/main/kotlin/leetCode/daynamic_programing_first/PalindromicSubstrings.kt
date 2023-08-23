package leetCode.daynamic_programing_first

class PalindromicSubstrings {
    fun countSubstrings(s: String): Int {
        var i = 0
        var repetitionCount = 0
        var count = s.length
        while (i < s.length) {
            repetitionCount = 0
            val start = i
            while (i+1 < s.length && s[i] == s[i+1]) {
                i++
                repetitionCount++
                count += repetitionCount
            }
            var l = start - 1
            var r = i + 1
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                count++
                l--
                r++
            }
            i++
        }
        return count
    }
}