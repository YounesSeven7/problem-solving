package leetCode.advancedGraphs

class AlienDictionary {
    fun alienOrder(words: Array<String>): String {
        val adjList = mutableMapOf<Char, MutableList<Char>>()
        for (i in 0 until words.lastIndex) {
            val currentWord = words[i]
            val nextWord = words[i + 1]
            val minLength = minOf(currentWord.length, nextWord.length)
            if (currentWord.subSequence(0, minLength) == nextWord.subSequence(0, minLength)
                && currentWord.length < nextWord.length) return ""
            for (j in 0 until minLength) {
                if (currentWord[j] != nextWord[j]) {
                    adjList.getOrPut(currentWord[j]) { mutableListOf() } += nextWord[j]
                    break
                }
            }


        }

        val visited = mutableSetOf<Char>()
        val path = mutableSetOf<Char>()
        val res = mutableListOf<Char>()

        fun dfs (char: Char): Boolean {
            if (path.contains(char)) return true
            if (visited.contains(char)) return false
            path.add(char)
            if (adjList.containsKey(char)) {
                val neighbors = adjList[char]
                for (nei in neighbors!!) dfs(nei)
            }
            visited.add(char)
            res.add(char)
            return false
        }

        for (node in adjList.keys) {
            path.clear()
            if (dfs(node)) return ""
        }
        res.reverse()
        return res.joinToString("")
    }
}