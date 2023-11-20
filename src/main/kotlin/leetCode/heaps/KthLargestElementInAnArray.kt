package leetCode.heaps

import java.util.PriorityQueue

class KthLargestElementInAnArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val priorityQueue = PriorityQueue<Int>()
        for (num in nums) {
            priorityQueue.add(num)
            if (priorityQueue.size > k) priorityQueue.poll()
        }
        return priorityQueue.poll()
    }
}