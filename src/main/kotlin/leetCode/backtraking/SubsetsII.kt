package leetCode.backtraking

class SubsetsII {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val list = mutableListOf<Int>()
        nums.sort()
        recursion(nums, 0, list, res)
        return res
    }

    fun recursion(nums: IntArray, index: Int, list: MutableList<Int>, res: MutableList<List<Int>>) {
        res.add(ArrayList(list))
        var i = index
        while (i < nums.size) {
            list.add(nums[i])
            recursion(nums, i+1, list, res)
            while (i + 1 < nums.size && list[list.size-1] == nums[i+1])
                i++
            list.removeAt(list.size-1)
            i++
        }
    }
}