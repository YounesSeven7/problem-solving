package leetCode.medium.slidingWindow

class LongestRepeatingCharacterReplacement {
    fun characterReplacement(s: String, k: Int): Int {
        if(s.length == k)
            return k

        var l = 0
        var r = 0
        var rightChar = s[r]
        var leftChar = s[l]
        var length = 0
        var max = 0
        var maxElement = 0
        val map = mutableMapOf<Char, Int>()
        map[rightChar] = 1

        while (r < s.length) {
            maxElement = 0
            for (element in map) {
                maxElement = Math.max(maxElement, element.value)
            }

            length = (r - l) + 1
            if (length - maxElement <= k) {
                max = Math.max(max, length)
                r++
                if(r == s.length) break
                rightChar = s[r]

                if (map.containsKey(rightChar))
                    map[rightChar] = map[rightChar]!! + 1
                else
                    map[rightChar] = 1

            } else {
                map[leftChar] =  map[leftChar]!! - 1
                l++
                leftChar = s[l]
            }
        }
        return max
    }
}