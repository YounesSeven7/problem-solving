package leetCode.slidingWindow

class MinimumWindowSubString {
    fun minWindow(s: String, t: String): String {
        if (s == t) return s
        if (s.length < t.length) return ""
        var l = 0
        var r = 0
        var count = 0
        var max = ""
        val constMap = saveStringInMap(t)
        val map = mutableMapOf<Char, Int>()

        while (l < s.length && constMap[s[l]] == null) l++
        r = l

        while (r < s.length) {
            if (constMap[s[r]] == null) {
                r++
            } else {
                map[s[r]] = map[s[r]]?.plus(1) ?: 1
                if (map[s[r]]!! <= constMap[s[r]]!!) count++
                r++
                while (count == t.length) {
                    max = if (max.isEmpty()) s.substring(l, r) else max
                    max = if ((r - l) < max.length) s.substring(l, r) else max
                    count = if (map[s[l]]!! > constMap[s[l]]!!) count else count - 1
                    map[s[l]] = map[s[l]]!! - 1
                    l++
                    while (l < s.length && constMap[s[l]] == null) l++
                }
            }
        }
        return max
    }

    fun saveStringInMap(t: String): Map<Char, Int> {
        val constMap = mutableMapOf<Char, Int>()
        t.onEach {char->
            constMap[char] = constMap[char]?.plus(1) ?: 1
        }
        return constMap
    }


    fun minWindow2(s: String, t: String): String {
        if (t.length > s.length) return ""
        if (s.length == t.length && s == t) return s

        val need = mutableMapOf<Char, Int>()
        val have = mutableMapOf<Char, Int>()

        for (char in t) {
            need[char] = need.getOrDefault(char, 0) + 1
            have[char] = 0
        }

        var l = 0
        var r = 0
        var max = ""
        var count = 0

        while (l < s.length) {

            while (l < s.length && !need.containsKey(s[l])) l++

            while (count < need.size) {
                if (r == s.length) return max
                val rChar = s[r]
                if(need.containsKey(rChar)) {
                    have[rChar] = have[rChar]!! + 1
                    if (have[rChar] == need[rChar]) count++
                }
                r++
            }
            if (max.isEmpty()) println("younes")
            if (max.isEmpty() || max.length > r - l) max = s.substring(l, r)
            have[s[l]] = have[s[l]]!! - 1
            if (have[s[l]]!! < need[s[l]]!!) count--
            l++
        }

        return max
    }
}