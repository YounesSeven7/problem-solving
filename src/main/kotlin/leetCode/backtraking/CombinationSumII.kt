package leetCode.backtraking

class CombinationSumII {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val list = mutableListOf<Int>()
        candidates.sort()
        recursion(candidates, target, 0, list, res)
        return res
    }

    fun recursion(candidates: IntArray, target: Int, index: Int, list: MutableList<Int>, res: MutableList<List<Int>>) {
        if (target == 0) {
            res.add(ArrayList(list))
            return
        }

        if (target < 0)
            return


        var i = index
        while (i < candidates.size) {
            list.add(candidates[i])
            recursion(candidates, target-candidates[i], i+1,list, res)
            while (i + 1 < candidates.size && list[list.size-1] == candidates[i+1])
                i++
            list.removeAt(list.size-1)
            i++
        }
    }
}