package leetCode.graphs

class MaxAreaOfIsland {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var max = 0
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (grid[r][c] != 0)
                    max = Math.max(max, recursion(r, c, grid))
            }
        }
        return max
    }

    fun recursion(row: Int, column: Int, grid: Array<IntArray>):Int {
        if (row >= grid.size  || column >= grid[0].size || row < 0 || column < 0
            || grid[row][column] == 0) return 0

        grid[row][column] = 0

        return (1 + recursion(row+1, column, grid)
        + recursion(row, column+1, grid)
        + recursion(row-1, column, grid)
        + recursion(row, column-1, grid))
    }
}