package leetCode.lincked_list

class CopyListWithRandomPointer {

    class Node(var `val`: Int,var next: Node? = null,var random: Node? = null)


    fun copyRandomList(node: Node?): Node? {
        val map = mutableMapOf<Node, Node>()
        var currentNode:Node? = node
        while (currentNode != null) {
            map[currentNode] = Node(currentNode.`val`)
            currentNode = currentNode.next
        }
        currentNode = node
        while (currentNode != null) {
            val newNode = map[currentNode]!!
            if (currentNode.next != null) newNode.next =  map[currentNode.next!!]
            if (currentNode.random != null) newNode.random =  map[currentNode.random!!]
            currentNode = currentNode.next
        }
        return map[node]
    }
}