package leetCode.greedy

import java.util.LinkedList
import java.util.Stack
import kotlin.math.max

class ValidParenthesisString {
    fun checkValidString(s: String): Boolean {
        var open = 0
        var minOpen = 0
        var maxOpen = 0
        for (char in s) {
            when (char) {
                '(' -> {
                    open++
                    minOpen++
                    maxOpen++
                }
                ')' -> {
                    open--
                    minOpen--
                    maxOpen--
                }
                else -> {
                    minOpen--
                    maxOpen++
                }
            }

            if (open < 0 && minOpen < 0 && maxOpen < 0) return false

            open = open.coerceAtLeast(0)
            minOpen = minOpen.coerceAtLeast(0)
            maxOpen = maxOpen.coerceAtLeast(0)

        }
        return open == 0 || minOpen == 0 || maxOpen == 0
    }


}