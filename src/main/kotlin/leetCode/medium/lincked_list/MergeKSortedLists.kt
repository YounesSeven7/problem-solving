package leetCode.medium.lincked_list

class MergeKSortedLists {
    class ListNode(var `val`: Int, var next: ListNode? = null)


    fun mergeKLists(
        lists: Array<ListNode?> = arrayOf(
            ListNode(1, ListNode(4, ListNode(6))),
            ListNode(2, ListNode(3))
        )
    ): ListNode? {
        if (lists.isEmpty()) return null

        var double = 1

        while (double < lists.size) {
            for (i in lists.indices step (2*double)) {
            lists[i] = mergeTwoLists(lists[i], if (i+double < lists.size) lists[i+double] else null)
            }
            double *= 2
        }
        return lists[0]
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var current1 = list1
        var current2 = list2

        var p = ListNode(0)
        var currentP = p

        while (current1 != null && current2 != null) {
            if (current1.`val` <= current2.`val`) {
                currentP.next = current1
                current1 = current1.next
            } else  {
                currentP.next = current2
                current2 = current2.next
            }
            currentP = currentP.next!!
        }

        if (current1 != null)
            currentP.next = current1
        else
            currentP.next = current2

        return p.next
    }
}