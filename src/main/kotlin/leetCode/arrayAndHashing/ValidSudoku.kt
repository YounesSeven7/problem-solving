package leetCode.arrayAndHashing

class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val columnHashMap = Array(9){ mutableSetOf<Char>() }
        val rowHashMap = Array(9) { mutableSetOf<Char>() }
        val subMatrix = Array(3) { Array(3) { HashSet<Char>() } }

        for (r in 0 until 9){
            for (c in 0 until 9) {
                val char = board[r][c]
                if (char == '.') continue
                if (columnHashMap[c].contains(char) || rowHashMap[r].contains(char)
                    || subMatrix[r/3][c/3].contains(char)) return false
                columnHashMap[c].add(char)
                rowHashMap[r].add(char)
                subMatrix[r/3][c/3].add(char)
            }
        }
        return true
    }
}