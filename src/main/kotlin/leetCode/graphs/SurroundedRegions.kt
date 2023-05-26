package leetCode.graphs

class SurroundedRegions {
    fun solve(board: Array<CharArray>): Unit {
        val row = board.size
        val column = board[0].size
        for (r in board.indices) {
            dfs(r, 0, board)
            dfs(r, column-1, board)
        }

        for (c in board[0].indices) {
            dfs(0, c, board)
            dfs(row-1, c, board)
        }

        for (r in board.indices)
            for (c in board[0].indices) {
                if (board[r][c] == 'O') board[r][c] = 'X'
                if (board[r][c] == 'T') board[r][c] = 'O'
            }
    }

    fun dfs(r: Int, c: Int, board: Array<CharArray>) {

        if (r !in board.indices || c !in board[0].indices || board[r][c] != 'O') return
        board[r][c] = 'T'
        dfs(r, c + 1, board)
        dfs(r,c - 1, board)
        dfs(r + 1, c, board)
        dfs(r - 1, c, board)
    }

}