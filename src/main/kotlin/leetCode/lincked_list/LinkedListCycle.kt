package leetCode.lincked_list

class LinkedListCycle {
    class ListNode(var `val`: Int, var next: ListNode? = null)

    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) false

        var slow = head
        var fast = head?.next

        while (true) {
            slow = slow?.next
            fast = fast?.next?.next
            if (fast == null)
                return false
            if (slow == fast)
                return true
        }
    }
}