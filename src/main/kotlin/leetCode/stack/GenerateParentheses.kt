package leetCode.stack

class GenerateParentheses {
    fun generateParentheses(n: Int): List<String>{
        val res = mutableListOf<String>()
        val list = mutableListOf<Char>()
        fun generate(open: Int, close: Int) {
            if(list.size - close < close) return
            if (open + close == n) {
                repeat(open) { list.add(')') }
                res.add(list.joinToString(""))
                repeat(open) { list.removeAt(list.size-1) }
                return
            }
            list.add('(')
            generate(open+1, close)
            list.removeAt(list.size-1)
            list.add(')')
            generate(open-1, close+1)
            list.removeAt(list.size-1)
        }
        generate(0, 0)
        return res
    }
}