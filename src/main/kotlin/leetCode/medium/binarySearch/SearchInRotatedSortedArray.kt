package leetCode.medium.binarySearch

class SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            val med = (l + r) / 2
            if (nums[med] == target)
                return med
            if (nums[med] >= nums[r]) {
                if (target < nums[r] || target > nums[med]) {
                    l = med + 1
                } else {
                    r = med - 1
                }
            } else {
                if (target > nums[r] || target < nums[med]) {
                    r = med - 1
                } else {
                    l = med + 1
                }
            }
        }
        return -1
    }
}