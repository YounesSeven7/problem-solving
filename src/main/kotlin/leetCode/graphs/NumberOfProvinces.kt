package leetCode.graphs

class NumberOfProvinces {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val parents = IntArray(isConnected.size + 1)
        println(parents.joinToString())
        for (i in parents.indices) parents[i] = i

        fun find(node: Int): Int {
            var p = parents[node]
            while (p != parents[p]) {
                parents[p] = parents[parents[p]]
                p = parents[p]
            }
            return p
        }

        fun union(parent: Int, son: Int) {
            if (find(son) != find(parent))
                parents[find(son)] = find(parent)
        }

        for (i in isConnected.indices) {
            for (j in 0 until isConnected[0].size) {
                if (i == j || isConnected[i][j] == 0) continue
                union(i+1, j+1)
            }
        }
        var count = 0
        for (i in 1 until parents.size)
            if (parents[i] == i) count++

        return count
    }
}