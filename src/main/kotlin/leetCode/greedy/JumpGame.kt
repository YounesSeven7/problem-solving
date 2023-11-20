package leetCode.greedy

class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        var jump = 0
        for (i in nums.size - 1 downTo 0) {
            if (nums[i] >= jump)
                jump = 0
            jump++
        }
        return jump == 1
    }
}