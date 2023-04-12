package leetCode.medium

class LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        var globalLength = 0
        var localLength = 0
        val set = nums.toHashSet()
        for (number in nums) {
            localLength = 1
            var element = number
            if (!set.contains(element - 1)) {
                while (set.contains(element + 1)) {
                    set.remove(element)
                    element++
                    localLength++
                }
            }
            globalLength = Math.max(globalLength, localLength)
        }
        return globalLength
    }

}