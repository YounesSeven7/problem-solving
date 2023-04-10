package leetCode.medium

import kotlin.math.max

class   LongestSubStringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty())
            return 0
        val map = mutableMapOf<Char, Int>()
        var i = 0
        var length = 0
        var max = 0
        var start = 0
        while (i < s.length){
            if (map[s[i]] == null) {
                map[s[i]] = i
                length++
            } else {
                length = i - (map[s[i]]!!)
                for (j in start..(map[s[i]]!!)) {
                    start = map[s[i]]!!
                    map.remove(s[j])
                }
                start++
                map[s[i]] = i
            }
            max = Math.max(length, max)
            i++
        }
        return max
    }
}