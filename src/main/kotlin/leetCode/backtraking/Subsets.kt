package leetCode.backtraking

class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        subsets(nums, 0, mutableListOf<Int>(), res)
        return res
    }

    fun subsets(nums: IntArray, idx: Int, list: MutableList<Int>, res: MutableList<List<Int>>) {
        res.add(ArrayList(list))

        for (i in idx until nums.size) {
            list.add(nums[i])
            subsets(nums, i+1, list, res)
            list.removeAt(list.size-1)
        }
    }
}