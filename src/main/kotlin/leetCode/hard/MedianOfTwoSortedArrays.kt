package leetCode.hard

import kotlin.math.min

class MedianOfTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val total = nums1.size + nums2.size
        val half = total / 2
        var arr1:IntArray = nums1
        var arr2:IntArray = nums2
        if(nums2.size < nums1.size) {
            arr1 = nums2
            arr2 = nums1
        }
        var l = 0
        var r = arr1.size - 1
        while (true) {
            val i = (l + r) / 2
            val j = half - i - 2

            val arr1Left = if (i >= 0) arr1[i].toDouble() else Double.NEGATIVE_INFINITY
            val arr1Right = if (i + 1 < arr1.size) arr1[i+1].toDouble() else Double.POSITIVE_INFINITY
            val arr2Left = if (j >= 0) arr2[j].toDouble() else Double.NEGATIVE_INFINITY
            val arr2Right = if (j+1 < arr2.size) arr2[j+1].toDouble() else Double.POSITIVE_INFINITY

            if (arr1Left <= arr2Right && arr2Left <= arr1Right) {
                return if (total % 2 == 0) {
                    (Math.min(arr1Left, arr2Left) + Math.max(arr1Right, arr2Right)).div(2.0)
                } else {
                    Math.min(arr1Left, arr2Left).toDouble()
                }
            } else if (arr1Left > arr2Right) {
                r = i - 1
            } else {
                l = i + 1
            }

        }
    }


}