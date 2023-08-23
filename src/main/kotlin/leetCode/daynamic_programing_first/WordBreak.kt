package leetCode.daynamic_programing_first

class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length) { true }
        fun recursion(startIndex: Int): Boolean {
            if (startIndex == s.length) return true
            if (!dp[startIndex]) return false
            var result = false
            for (word in wordDict) {
                if (s.length - startIndex >= word.length && (s.subSequence(startIndex, startIndex + word.length) == word)) {
                    result = recursion(startIndex + word.length)
                }
                if (result) return true
            }
            dp[startIndex] = false
            return false
        }
        return recursion(0)
    }


}