package leetCode.graphs

class RedundantConnection {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parents = IntArray(edges.size + 1)
        for (i in 1 until parents.size)
            parents[i] = i

        fun findRoot(n: Int): Int {
            var p = parents[n]
            while (p != parents[p]) {
                parents[p] = parents[parents[p]]
                p = parents[p]
            }
            return p
        }

        fun union(parent: Int, son: Int): Boolean {
            if (findRoot(parent) == findRoot(son)) {
                return false
            }
            parents[findRoot(son)] = findRoot(parent)
            return true
        }

        for (edg in edges) {
            if (!union(edg[0], edg[1])) return edg
        }
        return intArrayOf()
    }


}