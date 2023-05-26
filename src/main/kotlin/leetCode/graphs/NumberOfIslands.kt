package leetCode.graphs

class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (grid[r][c] != '0') {
                    recursion(r, c, grid)
                    count++
                }
            }
        }
        return count
    }

    fun recursion(row: Int, column: Int, grid: Array<CharArray>) {
        if (row >= grid.size  || column >= grid[0].size || row < 0 || column < 0
            || grid[row][column] == '0') return
        grid[row][column] = '0'

        recursion(row+1, column, grid)
        recursion(row, column+1, grid)
        recursion(row-1, column, grid)
        recursion(row, column-1, grid)
    }
}