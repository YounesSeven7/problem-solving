package leetCode.stack

import java.util.Stack

class EvaluateReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        for (token in tokens) {
            when(token) {
                "+", "-", "*", "/" -> stack.push(operation(token, stack))
                else -> stack.push(token.toInt())
            }
        }
        return stack.pop()
    }

    fun operation(token: String, stack: Stack<Int>): Int{
        val y = stack.pop()
        val x = stack.pop()
        return when(token) {
            "+" -> x + y
            "-" -> x - y
            "*" -> x * y
            else -> x / y
        }
    }
}