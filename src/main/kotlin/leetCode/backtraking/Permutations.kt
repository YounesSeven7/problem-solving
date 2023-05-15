package leetCode.backtraking

class Permutations {

    var count = 1

    fun permute(nums: IntArray): List<List<Int>> {
        val list = mutableListOf<Int>()
        val res = mutableListOf<List<Int>>()
        recursion(nums, list, res)
        return res
    }

    fun recursion(nums: IntArray, list: MutableList<Int>, res:MutableList<List<Int>>) {
        if (nums.size == 1) {
            list.add(nums[0])
            res.add(ArrayList(list))
            list.removeAt(list.size-1)
            return
        }

        val size = nums.size
        repeat(size) {i ->
            list.add(nums[0])
            val subArr = nums.copyOfRange(1, nums.size)
            recursion(subArr, list, res)
            if (i + 1 < size) {
                val temp = nums[0]
                nums[0] = nums[i+1]
                nums[i+1] = temp
            }
            list.removeAt(list.size-1)
        }
    }
}