package leetCode.BinManipulation

class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        var missingNumber = nums.size
        for(i in nums.indices) missingNumber = missingNumber xor i xor nums[i]
        return missingNumber
    }
}