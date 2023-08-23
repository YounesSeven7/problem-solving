package leetCode.heaps

import java.util.PriorityQueue

class FindMedianFromDataStream {
    val smallMaxHeap  = PriorityQueue<Int>{a, b -> b-a}
    val largeMinHeap = PriorityQueue<Int>{a, b -> a-b}

    fun addNum(num: Int) {
        if (smallMaxHeap.isEmpty() || num <= smallMaxHeap.peek()) smallMaxHeap.add(num)
        else largeMinHeap.add(num)

        if (smallMaxHeap.size > largeMinHeap.size + 1) largeMinHeap.add(smallMaxHeap.remove())
        else if (largeMinHeap.size > smallMaxHeap.size) smallMaxHeap.add(largeMinHeap.remove())
    }

    fun findMedian(): Double {
        return if ((smallMaxHeap.size + largeMinHeap.size) % 2 == 0) {
            (smallMaxHeap.peek() + largeMinHeap.peek()) / 2.0
        } else {
            smallMaxHeap.peek().toDouble()
        }
    }
}