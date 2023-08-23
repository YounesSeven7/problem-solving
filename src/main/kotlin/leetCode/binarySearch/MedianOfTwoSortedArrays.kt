package leetCode.binarySearch

import kotlin.math.min

class MedianOfTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums2.size < nums1.size) return findMedianSortedArrays(nums2, nums1)
        val n1 = nums1.size
        val n2 = nums2.size

        var low = 0
        var high = n1

        val half = (n1 + n2 + 1) / 2

        while (low <= high) {
            var cut1 = (low + high) shr 1
            var cut2 = half - cut1
            if (nums2.isEmpty()) {
                cut1 = half
                cut2 = 0
            }

            val left1 = if (cut1 == 0) Int.MIN_VALUE else nums1[cut1 - 1]
            val left2 = if (cut2 == 0) Int.MIN_VALUE else nums2[cut2 - 1]

            val right1 = if (cut1 == nums1.size) Int.MAX_VALUE else nums1[cut1]
            val right2 = if (cut2 == nums2.size) Int.MAX_VALUE else nums2[cut2]

            if (left1 <= right2 && left2 <= right1)
                return if ((n1 + n2) % 2 == 0) ((maxOf(left1, left2) + minOf(right1, right2)) / 2.0)
                else maxOf(left1, left2).toDouble()

            if (left1 > right2) high = cut1 - 1
            else low = cut1 + 1
        }
        return 0.0
    }
}