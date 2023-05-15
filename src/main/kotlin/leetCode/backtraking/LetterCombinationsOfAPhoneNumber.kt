package leetCode.backtraking

class LetterCombinationsOfAPhoneNumber {

    fun letterCombinations(digits: String): List<String> {
        val res = mutableListOf<String>()
        if (digits.isEmpty()) return res
        val list = mutableListOf<Char>()
        recursion(0, digits, list, res)
        return res
    }


    fun recursion(dI: Int, digits: String, list: MutableList<Char>, res: MutableList<String>) {
        if (list.size == digits.length){
            var s = ""
            for (char in list) {
                s += char
            }
            res.add(s)
            return
        }

        val charArray = generateLetters(digits[dI].toString().toInt())
        for (element in charArray) {
            list.add(element)
            recursion(dI+1, digits, list, res)
            list.removeAt(list.size-1)
        }
    }

    fun generateLetters(digit: Int) : CharArray {
        val size = if (digit == 9 || digit == 7) 4 else 3
        var asciiCode = (digit-2)*3 + 97
        val charArray = CharArray(size)
        if (digit == 8 || digit == 9) asciiCode++
        repeat(size) {i ->
            charArray[i] = (asciiCode + i).toChar()
        }
        return charArray
    }
}