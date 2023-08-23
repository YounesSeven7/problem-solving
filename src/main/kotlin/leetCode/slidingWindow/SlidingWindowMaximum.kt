package leetCode.slidingWindow

import java.util.Deque
import kotlin.time.Duration.Companion.seconds

class SlidingWindowMaximum {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val deque = arrayListOf<Int>()
        val list = IntArray(nums.size - k + 1)
        var i = 0
        var slidingIndex = 0
        while (i < nums.size) {
            if (deque.isNotEmpty())
                if (deque.size == k || deque.first() <= i - k ) deque.removeAt(0)

            while (deque.isNotEmpty() && nums[deque[deque.size - 1]] < nums[i]) deque.removeAt(deque.size - 1)

            deque.add(i)
            if (i - k + 1 >= 0) list[slidingIndex++] = nums[deque[0]]
            i++
        }
        return list
    }

    fun maxSlidingWindow2(nums: IntArray, k: Int): IntArray {
        if (nums.isEmpty() || k == 0) {
            return intArrayOf()
        }
        var i = 0
        val queue = arrayListOf<Int>()
        val array = IntArray(nums.size - k + 1)
        var slideIndex = 0

        while (i < nums.size) {
            /**
             * remove head if it is out of range of the sliding window
             */
            if (queue.isNotEmpty() && i - queue[0] == k) {
                queue.removeAt(0)
            }

            /**
             * remove from the tail if it's smaller than nums[i]
             */
            var j = queue.size - 1
            while (queue.isNotEmpty() && j >= 0 && nums[queue[j]] < nums[i]) {
                queue.removeAt(queue.size - 1)
                j --
            }

            queue.add(i)
            if (i - k + 1 >= 0) {
                array[slideIndex ++] = nums[queue[0]]
            }

            i++
        }

        return array
    }
}