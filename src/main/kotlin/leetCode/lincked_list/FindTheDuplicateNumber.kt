package leetCode.lincked_list

class FindTheDuplicateNumber {
    fun findDuplicate(nums: IntArray): Int {
        var fast = nums[nums[0]]
        var slow = nums[0]
        var start = 0
        while (fast != slow) {
            slow = nums[slow]
            fast = nums[nums[fast]]
        }
        val temp = slow
        while (start != slow) {
            start = nums[start]
            slow = nums[slow]
        }
        print(start)
        return slow
    }
}