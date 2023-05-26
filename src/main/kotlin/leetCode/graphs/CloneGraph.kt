package leetCode.graphs

class CloneGraph {
    class Node(var `val`: Int) { var neighbors: ArrayList<Node?> = ArrayList<Node?>() }

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        val map = mutableMapOf<Int,Node>()
        return recursion(node, map)
    }

    fun recursion(node: Node, map: MutableMap<Int,Node>): Node {
        val newNode = Node(node.`val`)
        map[node.`val`] = newNode
        for (neighbor in node.neighbors) {
            if (neighbor == null) continue
            if (map.contains(neighbor.`val`)) {
                newNode.neighbors.add(map[neighbor.`val`])
                continue
            } else {
                val nextNode = recursion(neighbor, map)
                newNode.neighbors.add(nextNode)
            }

        }
        return newNode
    }
}