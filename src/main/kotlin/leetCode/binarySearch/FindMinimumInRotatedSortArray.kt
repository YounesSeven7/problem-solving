package leetCode.binarySearch

class FindMinimumInRotatedSortArray {

    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        while (l != r) {
            var med = (l + r) / 2
            if (nums[r] >= nums[med])
                r = med
            else if (nums[r] < nums[med])
                l = med + 1
        }
        return nums[l]
    }
}