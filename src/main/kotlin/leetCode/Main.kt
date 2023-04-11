package leetCode

import algoritme.sorting.QuickSort
import leetCode.dataStructures.ListNode
import leetCode.hard.LongestHappyPrefix
import leetCode.hard.MedianOfTwoSortedArrays
import leetCode.medium.AddTwoNumbers
import leetCode.medium.LongestSubStringWithoutRepeatingCharacters
import leetCode.medium.MaximumSubarray
import leetCode.medium.ProductOfArrayExceptSelf

fun main() {
    val productOfArrayExceptSelf = ProductOfArrayExceptSelf()
    val arr = productOfArrayExceptSelf.productExceptSelf(intArrayOf(1, 2, 3, 4))
    arr.onEach {
        print("$it ")
    }

}