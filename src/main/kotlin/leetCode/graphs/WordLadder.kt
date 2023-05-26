package leetCode.graphs

import java.util.LinkedList

class WordLadder {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val set = wordList.toMutableSet()

        if (!set.contains(endWord)) return 0

        val queue = LinkedList<String>()
        var step = 0
        queue.add(beginWord)
        set.remove(beginWord)

        while (queue.isNotEmpty()) {
            step++
            repeat(queue.size) {
                val current = queue.pop()
                set.remove(current)

                if (current == endWord)
                    return step

                val neighbors = getNeighbors(current, set)
                for (neighbor in neighbors) {
                    queue.add(neighbor)
                }
            }
        }
        return step
    }


    fun getNeighbors(word: String, set: Set<String>): List<String> {
        val neighbors = mutableListOf<String>()
        val chars = word.toCharArray()

        for (i in chars.indices) {
            val oldChar = chars[i]
            for (newChar in 'a'..'z') {
                chars[i] = newChar
                val new = String(chars)
                if (set.contains(new))
                    neighbors.add(new)
            }
            chars[i] = oldChar
        }
        return neighbors
    }

}