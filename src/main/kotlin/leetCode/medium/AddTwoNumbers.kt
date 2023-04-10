package leetCode.medium

import leetCode.dataStructures.ListNode

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var listNode1:ListNode? = l1
        var listNode2:ListNode? = l2
        val listNode3 = ListNode(0)
        var current:ListNode? = listNode3
        var nextValue = 0
        while (listNode1 != null ||  listNode2 != null) {
            val x = listNode1?.value ?: 0
            val y = listNode2?.value ?: 0
            var sum = x + y + nextValue
            nextValue = sum / 10
            current?.next = ListNode(sum % 10)
            current = current?.next
            if (listNode1 != null)
                listNode1 = listNode1.next
            if (listNode2 != null)
                listNode2 = listNode2.next
        }
        if(nextValue > 0)
            current?.next = ListNode(nextValue)
        return listNode3.next
    }
}