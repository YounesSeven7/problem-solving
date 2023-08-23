package leetCode.lincked_list

class RemoveNthNodeFromEndOfList {
    class ListNode(var `val`: Int) {
             var next: ListNode? = null
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head?.next == null) return null

        var fast = head
        var _n = n

        while (_n > 0) {
            fast = fast?.next
            _n--
        }

        var slow = head
        var pSlow = slow

        while (fast != null) {
            pSlow = slow
            slow = slow?.next
            fast = fast?.next
        }
        if (slow == pSlow)
            return pSlow!!.next

        pSlow!!.next = pSlow!!.next?.next
        return head
    }
}