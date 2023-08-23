package leetCode.lincked_list

class ReverseNodesInkGroup {
    class ListNode(var value: Int, var next: ListNode? = null)

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val newListNode = ListNode(0)
        var prev = newListNode
        var start = head
        var next: ListNode?
        while (start != null) {
            var current = start
            var count = 1
            while (count < k) {
                if (current!!.next == null) break
                current = current.next
                count++
            }
            next = current!!.next
            current.next = null
            val newGroup = if (count == k) reverseList(start) else start
            prev.next = newGroup
            prev = start
            start = next
        }
        return newListNode.next
    }

    fun reverseList(list: ListNode?): ListNode? {
        if(list?.next == null) return list
        return recursion(list)
    }

    fun recursion(list:ListNode?): ListNode? {
        if (list?.next?.next == null) {
            list?.next?.next = list
            val temp = list?.next
            list?.next = null
            return temp
        }
        val node = recursion(list.next)
        list.next?.next = list
        list.next = null
        return node
    }
}