package leetCode.Tries

class WordDictionary {
    class Trie {
        val next = Array<Trie?>(26){ null }
        var isTheEnd = false
    }
    val root = Trie()

    fun addWord(word: String) {
        var cur = root
        for (char in word)
            cur = cur.next[char - 'a'] ?: Trie().also { cur.next[char - 'a']  = it}
        cur.isTheEnd = true
    }

    fun search(word: String): Boolean {
        fun dfs(i: Int, root: Trie?): Boolean {
            if (root == null) return false
            if (i == word.length) return root.isTheEnd
            val char = word[i]
            if (char == '.') {
                for (next in root.next) {
                    if (dfs(i + 1, next)) return true
                }
                return false
            } else return dfs(i + 1, root.next[char - 'a'])

        }
        return dfs(0, root)
    }
}