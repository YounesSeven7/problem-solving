package leetCode.stack

import java.util.Stack

class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        if (temperatures.size == 1) return intArrayOf(0)

        val stack = Stack<Int>()
        var i = 1
        var currentMax = temperatures[0]
        stack.add(0)

        while (i < temperatures.size) {
            while (stack.isNotEmpty() && currentMax < temperatures[i]) {
                val indexOfMax = stack.pop()
                temperatures[indexOfMax] = i - indexOfMax
                if (stack.isNotEmpty())
                    currentMax = temperatures[stack.peek()]
            }
            stack.push(i)
            currentMax = temperatures[i]
            if (stack.isNotEmpty() && i == temperatures.size-1)  {
                while (stack.isNotEmpty()) {
                    temperatures[stack.pop()] = 0
                }
            }
            i++
        }
        temperatures[temperatures.size - 1] = 0
        return temperatures
    }
}