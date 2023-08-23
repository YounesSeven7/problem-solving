package leetCode.arrayAndHashing

class EncodeAndDecodeStrings {
    fun enCodeString(words : Array<String>): String{
        val string = StringBuilder()
        string.append(words.size)
        for (word in words)
            string.append("(${word.length})$word")
        return string.toString()
    }

    fun deCodeString(code: String): Array<String>{
        var start = 0
        var end = 0

        while (code[end] - '0' in 0..9) end++
        val size = fromStringToInt(code.substring(0, end))
        val words = Array(size) { "" }

        end++
        start = end
        var i = 0
        while (end < code.length) {
            while (code[end] != ')')
                end++
            val sizeOfWord = fromStringToInt(code.substring(start, end))
            end++
            start = end
            val word = code.substring(start, start + sizeOfWord)
            words[i] = word
            i++
            start += sizeOfWord + 1
            end = start
        }
        println(size)
        return words
    }

    private fun fromStringToInt(string: String): Int {
        return Integer.parseInt(string)
    }
}