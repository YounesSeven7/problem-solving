package leetCode.graphs

class PacificAtlanticWaterFlow {

    val dirs = arrayOf(intArrayOf(0,1),
        intArrayOf(0,-1),
        intArrayOf(1,0),
        intArrayOf(-1,0))

    fun pacificAtlantic(grid: Array<IntArray>): List<List<Int>> {
        if (grid.isEmpty()) return emptyList()
        val list = mutableListOf<List<Int>>()

        val row = grid.size
        val column = grid[0].size

        val pacific = Array(grid.size) { BooleanArray(grid[0].size) }
        val atlantic = Array(grid.size) { BooleanArray(grid[0].size) }

        for (i in grid.indices) {
            dfs(grid, Int.MIN_VALUE, i, 0, pacific)
            dfs(grid, Int.MIN_VALUE, i, column-1, atlantic)
        }

        for (i in grid[0].indices) {
            dfs(grid, Int.MIN_VALUE, 0, i, pacific)
            dfs(grid, Int.MIN_VALUE, row-1, column - 1 - i, atlantic)
        }

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (pacific[i][j] && atlantic[i][j]) list.add(listOf(i, j))
            }
        }


        return list
    }

    private fun dfs(grid: Array<IntArray>, height: Int, i: Int, j: Int, visited: Array<BooleanArray>) {
        if(i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] < height || visited[i][j]) return

        visited[i][j] = true


        dfs(grid, grid[i][j], i, j + 1, visited)
        dfs(grid, grid[i][j], i  , j - 1, visited)
        dfs(grid, grid[i][j], i + 1 , j, visited)
        dfs(grid, grid[i][j], i - 1 , j, visited)
    }

}