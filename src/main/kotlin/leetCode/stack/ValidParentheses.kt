package leetCode.stack

import java.util.Stack

class ValidParentheses {
    fun isValid(s: String): Boolean {
        if (s.length % 2 == 1) return false
        val stack = Stack<Char>()
        val map = hashMapOf('(' to ')', '{' to '}', '[' to ']')
        for (c in s) {
            if(map.containsKey(c))
                stack.add(c)
            else if (stack.isEmpty() || map[stack.pop()] != c) return false
        }
        return stack.isEmpty()
    }
}

