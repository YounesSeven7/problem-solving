package leetCode

import algoritme.sorting.QuickSort
import leetCode.dataStructures.ListNode
import leetCode.hard.LongestHappyPrefix
import leetCode.hard.MedianOfTwoSortedArrays
import leetCode.medium.*

fun main() {
    val longestConsecutiveSequence = LongestConsecutiveSequence()
    val number = longestConsecutiveSequence.longestConsecutive(intArrayOf(100, 5, 4,200, 1, 3, 2))
    print("-> $number")

}