package leetCode.backtraking



class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val maxRow = board.count()
        val maxColumn = board[0].size
        val path = mutableSetOf<String>()

        fun recursion(r: Int, c: Int, i: Int): Boolean {
            if (i == word.length)
                return true

            if (r < 0 || r >= maxRow || c < 0 || c >= maxColumn || path.contains("$r,$c") || word[i] != board[r][c]) {
                return false
            }

            path.add("$r,$c")
            val res = recursion(r+1, c, i + 1) ||
                    recursion(r, c+1, i +1) ||
                    recursion(r-1, c, i+1) ||
                    recursion(r, c-1, i+1)
            path.remove("$r,$c")
            return res
        }

        for (r in board.indices)
            for (c in board[0].indices)
                if (recursion(r, c, 0)) return true

        return false
    }
}