package leetCode.greedy

class PartitionLabels {
    fun partitionLabels(s: String): List<Int> {
            val set = mutableSetOf<Char>()
            val list = mutableListOf<Int>()

            var start = 0
            var end = 1
            var currentCharIndex = 0

            while (end < s.length) {
                while (currentCharIndex < end) {
                    val currentChar = s[currentCharIndex]

                    if (!set.contains(currentChar))
                        for (i in end until s.length)
                            if (s[i] == currentChar) end = i + 1

                    set.add(currentChar)
                    currentCharIndex++
                }
                list.add(end - start )
                start = currentCharIndex
                end++
            }

            return list
    }
}