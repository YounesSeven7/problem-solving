package leetCode.daynamic_programing_first

class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        var res = s[0].toString()
        var length = 1
        var i = 0
        while (i < s.length - 1) {
            length = 1
            val start = i
            while (i+1 < s.length && s[i] == s[i+1])  {
                length++
                i++
            }

            var l = start-1
            var r = i+1


            while (l > 0 && r < s.length) {
                if (s[l] == s[r]) {
                    l--
                    r++
                    length += 2
                } else break
            }
            if (length > res.length)
                res = s.substring(l+1, r)
            i = r
        }
        return res
    }
}