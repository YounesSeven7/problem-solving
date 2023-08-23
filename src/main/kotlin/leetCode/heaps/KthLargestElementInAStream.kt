package leetCode.heaps

import java.util.PriorityQueue

class KthLargestElementInAStream  {
    var k = 0
    val heap: PriorityQueue<Int> = PriorityQueue{a, b -> a-b}

    constructor(k: Int, nums: IntArray) {
        this.k = k
        for (element in nums) {
            heap.add(element)
        }

        while (heap.size > k)
            heap.remove()
    }

    fun add(`val`: Int): Int {
        heap.add(`val`)
        if (heap.size > k)
            heap.remove()
        return heap.peek()
    }

}