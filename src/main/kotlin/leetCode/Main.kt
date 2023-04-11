package leetCode

import algoritme.sorting.QuickSort
import leetCode.dataStructures.ListNode
import leetCode.hard.LongestHappyPrefix
import leetCode.hard.MedianOfTwoSortedArrays
import leetCode.medium.AddTwoNumbers
import leetCode.medium.LongestSubStringWithoutRepeatingCharacters
import leetCode.medium.MaximumSubarray

fun main() {
    val quickSort = QuickSort()
    val arr = intArrayOf(42, 15, 20, 53, 54, 28, 10, 52, 45, 55, 12, 110, 17, 30, 37, 2, 36)
    quickSort.sortThis(arr, 0, arr.size-1)
    arr.onEach {
        print("$it ")
    }
}