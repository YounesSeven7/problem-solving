package leetCode.lincked_list

class LRUCache(val capacity: Int) {
    class Node(var `val`: IntArray,var next: Node? = null,var prev: Node? = null)
    val head = Node(intArrayOf())
    val tail = Node(intArrayOf())
    val map = mutableMapOf<Int, Node>()
    init {
        tail.prev = head
        head.next = tail
    }
    fun get(key: Int): Int {
        if (!map.containsKey(key)) return -1
        val node = map[key]!!
        moveToTheFront(node)
        return node.`val`[1]
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            map[key]!!.`val`[1] = value
            moveToTheFront(map[key]!!)
            return
        }
        val newNode = Node(intArrayOf(key, value))
        if (map.size == capacity) {
            removeLastNode()
        }
        map[key] = newNode
        putInTheFront(newNode)
    }

    private fun putInTheFront(node: Node) {
        val temp = head.next!!
        head.next = node
        node.prev = head
        node.next = temp
        temp.prev = node
    }

    private fun removeLastNode() = remove(tail.prev!!)

    fun remove(node: Node) {
        map.remove(node.`val`[0])
        val prev = node.prev!!
        val next = node.next!!
        prev.next = next
        next.prev = prev
    }

    fun moveToTheFront(node: Node) {
        remove(node)
        map[node.`val`[0]] = node
        putInTheFront(node)
    }
}