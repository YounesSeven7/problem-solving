package leetCode.medium.lincked_list

class ReorderList {
    class ListNode(var value: Int, var next: ListNode? = null)
    fun reorderList(head: ListNode?): Unit {
        var head: ListNode? =
            ListNode(1,
                ListNode(2,
                    ListNode(3)))


        var slow = head
        var fast = head?.next
        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast!!.next?.next
        }

        var current1 = head
        var current2 = if (slow!!.next?.next == null) slow!!.next else recursion(slow!!.next)
        slow.next = null

        val p = current1
        var currentP = p
        current1 = current1?.next

        while (current1 != null || current2 != null) {
            val next1 = current1?.next
            val next2 = current2?.next

            currentP?.next = current2
            currentP = currentP?.next
            current2 = next2

            currentP?.next = current1
            currentP = currentP?.next
            current1 = next1
        }

        current2 = p

        while (current2 != null) {
            print("${current2.value}")
            current2 = current2.next
        }

    }

    fun recursion(list: ListNode?): ListNode? {
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