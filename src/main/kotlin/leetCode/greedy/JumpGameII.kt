package leetCode.greedy

class JumpGameII {
    fun jump(nums: IntArray): Int {
        var (l, r, res) = intArrayOf(0, 0, 0)

        while (r < nums.size - 1) {
            var maxJump = 0
            for (i in l..r)
                maxJump = maxOf(maxJump, nums[i] + i)

            l = r + 1
            r = maxJump
            res++
        }
        return res
    }
}