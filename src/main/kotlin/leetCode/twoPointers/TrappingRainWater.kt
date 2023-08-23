package leetCode.twoPointers

import kotlin.math.min

class TrappingRainWater {
    fun trap(height: IntArray): Int {
        var res = 0
        var l = 0
        var maxL = height[l]
        var r = height.size - 1
        var maxR = height[r]

        while (l < r) {
            if (maxL <= maxR) {
                l++
                res += (minOf(maxL, maxR) - height[l]).coerceAtLeast(0)
                maxL = maxOf(maxL, height[l])
            } else {
                r--
                res += (minOf(maxL, maxR) - height[r]).coerceAtLeast(0)
                maxR = maxOf(maxR, height[r])
            }
        }
        return res
    }
}