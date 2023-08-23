package leetCode.lincked_list

class MergeTwoSortedLists {
    class ListNode(var `val`: Int, var next: ListNode? = null)


    fun mergeTwoLists(): ListNode? {
        var current1: ListNode? = ListNode(1, ListNode(2, ListNode(3)))
        var current2: ListNode? = ListNode(2)

        var p = ListNode(0)
        var currentP = p

        while (current1 != null && current2 != null) {
            if (current1.`val` <= current2.`val`) {
                currentP.next = current1.next
                current1 = current1.next
            } else  {
                currentP.next = current2
                current2 = current2.next
            }
            currentP = currentP.next!!
        }

        if (current1 == null) {
            currentP.next = current2
        } else {
            currentP.next = current1
        }

        var node: ListNode? = p
        while (node != null) {
            print("${node.`val`}")
            node = node.next
        }

        return p.next
    }
}