package leetCode.arrayAndHashing

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val count = IntArray(26)
        val map = mutableMapOf<String, MutableList<String>>()

        for (i in strs.indices) {
            for (j in count.indices) count[j] = 0
            val word = strs[i]
            for (c in word) count[c - 'a']++
            map.getOrPut(count.joinToString()) { mutableListOf() }.add(word)
        }
        val res = ArrayList<List<String>>(map.size)

        for (list in map.values) res.add(list)
        return res
    }


}