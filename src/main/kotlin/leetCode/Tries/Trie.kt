package leetCode.Tries

class Trie {
    val next = Array<Trie?>(26){ null }
    var isTheEnd = false

    fun insert(word: String) {
        var cur = this
        for (char in word)
            cur = cur.next[char - 'a'] ?: Trie().also { cur.next[char - 'a'] = it }
        cur.isTheEnd = true
    }

    fun search(word: String): Boolean = search(word, false)

    fun startsWith(prefix: String): Boolean = search(prefix, true)

    fun search(word: String, prefix: Boolean): Boolean {
        var cur = this
        for (char in word) {
            cur = cur.next[char - 'a'] ?: return false
        }
        return prefix || cur.isTheEnd
    }
}