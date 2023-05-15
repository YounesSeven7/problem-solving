package leetCode.backtraking

class PalindromePartitioning {
    fun partition(s: String): List<List<String>> {
        val res = mutableListOf<List<String>>()
        val list = mutableListOf<String>()
        recursion(0, s, list, res)

        return res
    }

    fun recursion(i: Int, s:String, list: MutableList<String>, res: MutableList<List<String>>) {
        if (i == s.length)
            res.add(ArrayList(list))


        for (j in i until s.length) {
            if (!isPalindrome(i, j, s)) continue
            val sub = s.subSequence(i, j+1).toString()
            list.add(sub)
            recursion(j+1, s, list, res)
            list.removeAt(list.size-1)

        }
    }

    fun isPalindrome(l: Int, r: Int, s: String): Boolean {
        if (l >= r) return true
        return s[l] == s[r] && isPalindrome(l+1, r-1, s)
    }
}