package leetCode.slidingWindow

class PermutationInString {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val map = mutableMapOf<Char, Int>()

        for (char in s1)
            map[char] = map.getOrDefault(char, 0) + 1

        var count = 0
        var start = 0
        for (end in s2.indices) {
            val endChar = s2[end]
            if (map.containsKey(endChar)) {
                map[endChar] = map[endChar]!! - 1
                if (map[endChar]!! == 0)
                count++
            }

            while (count == map.size) {
                val startChar = s2[start]
                if (map.containsKey(startChar)) {
                    map[startChar] = map[startChar]!! + 1
                    if (map[startChar]!! > 0)
                        count--
                }

                if (count < map.size && end - start + 1 == s1.length)
                    return true

                start++
            }
        }
        return false
    }
}