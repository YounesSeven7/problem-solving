package leetCode.stack

import java.util.Stack

class LargestRectangleInHistogram {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = Stack<Pair<Int, Int>>()
        var maxArea = 0
        var pop = 0
        var index = 0
        for (i in heights.indices) {
            index = i
            pop = 0
            if (stack.isEmpty()) stack.push(Pair(i, heights[i]))
            while (stack. isNotEmpty() && stack.peek().second > heights[i]) {
                pop++
                index = stack.peek().first
                maxArea = Math.max(maxArea, stack.pop().second * (i - index + 1))
            }
            stack.push(Pair(index, heights[i]))
        }
        while (stack.isNotEmpty()) {
            maxArea = Math.max(maxArea, stack.peek().second * (heights.size - stack.pop().first))
        }
        return maxArea
    }
}