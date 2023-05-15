package leetCode.backtraking

class NQueens {
    fun solveNQueens(n: Int): List<List<String>> {
        val set = mutableSetOf<String>()
        val list = mutableListOf<String>()
        val res = mutableListOf<List<String>>()
        recursion(0, set, list, res, n)
        return res
    }

    fun recursion(row: Int, set: MutableSet<String>, list: MutableList<String>, res: MutableList<List<String>>, n: Int) {
        if (list.size == n) {
            res.add(ArrayList(list))
            return
        }

        for (column in 0 until n) {
            if (set.contains("$column,$row")) continue
            var s = ""
            repeat(n) { j-> s += if (j != column) '.' else 'Q'}
            list.add(s)
            val blunderList = getBlunderList(column, set,row, n)
            for (blunder in blunderList) { set.add(blunder) }
            recursion(row+1, set, list, res, n)
            for (blunder in blunderList) { set.remove(blunder) }
            list.removeAt(list.size-1)
        }
    }


    fun getBlunderList(column: Int, set: MutableSet<String>,row: Int, n: Int) : List<String> {
        val blunderList = mutableListOf<String>()
        for (r in (row+1) until n) {
            if (!set.contains("$column,$r"))
                blunderList.add("$column,$r")
        }
        var c = column
        var r = row
        while (c+1 < n && r+1 < n) {
            c++
            r++
            if (!set.contains("$c,$r"))
                blunderList.add("$c,$r")
        }
        c = column
        r = row
        while (c-1 >= 0 && r+1 < n) {
            c--
            r++
            if (!set.contains("$c,$r"))
                blunderList.add("$c,$r")
        }
        return blunderList
    }
}