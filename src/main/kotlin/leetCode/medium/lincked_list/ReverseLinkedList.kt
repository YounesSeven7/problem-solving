package leetCode.medium.lincked_list


class ReverseLinkedList {

    class ListNode(var value: Int, var next: ListNode? = null) {
    }

    fun reverseList(): ListNode? {
        var head: ListNode? = ListNode(1, ListNode(2, ListNode(3)))

        var p: ListNode? = null
        var c: ListNode? = head

        while (c != null) {
            val temp = c.next
            c.next = p
            p = c
            c = temp
        }
        return c
    }

    fun reverseListRecursionally(): ListNode? {
        var head: ListNode? = ListNode(1)
        var node = recursion(head)
        while (node != null) {
            print("${node.value}")
            node = node.next
        }
        return node
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