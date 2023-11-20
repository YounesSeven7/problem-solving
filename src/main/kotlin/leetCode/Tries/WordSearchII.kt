package leetCode.Tries

class WordSearchII {
    class Trie{
        val next = Array<Trie?>(26){ null }
        var word: String? = null
    }

    val root = Trie()
    val arr = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0)
    )

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        for (word in words) insert(word)

        val n = board.size
        val m = board[0].size
        val path = Array(n) { BooleanArray(m) }
        val res = mutableListOf<String>()

        fun dfs(i: Int, j: Int, root: Trie) {
            if (i !in board.indices || j !in board[0].indices || path[i][j] ||
                root.next[board[i][j] - 'a'] == null ) return

            val char = board[i][j]
            val currentTrie = root.next[char - 'a']!!

            if (currentTrie.word != null) {
                res.add(currentTrie.word!!)
                currentTrie.word = null
            }

            path[i][j] = true

            for ((row, column) in arr) dfs(i + row, j + column, currentTrie)

            path[i][j] = false
        }
        for (i in board.indices)
            for (j in board[0].indices)
                dfs(i, j, root)
        return res
    }

    fun insert(word: String) {
        var cur = root
        for (char in word) {
            cur = cur.next[char - 'a'] ?: Trie().also { cur.next[char - 'a'] = it }
        }
        cur.word = word
    }
}