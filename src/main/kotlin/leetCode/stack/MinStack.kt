package leetCode.stack

class MinStack {
    class Node(val value: Int, val min: Int, val next: Node?)

    var head: Node? = null

    fun push(`val`: Int) {
        if (head != null) {
            head = Node(`val`, Math.min(`val`, head!!.min), head)
            return
        }
        head = Node(`val`, `val`, null)
    }

    fun pop() {
        head = head!!.next
    }

    fun top(): Int {
        return head!!.value
    }

    fun getMin(): Int {
        return head!!.min
    }
}