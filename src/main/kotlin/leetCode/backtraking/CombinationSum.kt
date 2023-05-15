package leetCode.backtraking

class CombinationSum {

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val list = mutableListOf<Int>()
        candidates.sort()
        recursion(candidates, target, 0, list, res)
        return res
    }

    fun recursion(candidates: IntArray, target: Int, index: Int,list: MutableList<Int>, res: MutableList<List<Int>>) {

        if (target == 0) {
            res.add(ArrayList(list))
            return
        }

        if (index >= candidates.size || target < 0)
            return


        for (i in index until candidates.size) {
            list.add(candidates[i])
            recursion(candidates, target - candidates[i], i, list, res)
            list.removeAt(list.size - 1)
        }
    }

}