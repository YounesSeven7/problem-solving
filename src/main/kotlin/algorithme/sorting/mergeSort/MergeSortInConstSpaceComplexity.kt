package algorithme.sorting.mergeSort

class MergeSortInConstSpaceComplexity {
    // Todo I wont to make merge sort in 0(1) space complexity and O(nlog(n)) time complexity.
    fun sortThis(arr: IntArray): IntArray{
        return sort(arr, 0, arr.size-1)
    }

    fun sort(arr: IntArray, left: Int, right: Int): IntArray {
        if (left == right)
            return arr
        val med = (left + right) / 2
        sort(arr, left, med)
        sort(arr, med+1, right)
        return mergeArr(
            arr = arr,
            startLeftArr = left,
            endLeftArr = med,
            startRightArr = right,
            endRightArr = right
        )
    }

    fun mergeArr(arr: IntArray, startLeftArr: Int, endLeftArr: Int, startRightArr: Int, endRightArr: Int): IntArray {
        var left = startLeftArr
        var right = startRightArr
        while (left <= endLeftArr && right <= endRightArr) {
            if (arr[left] > arr[right]) {
                swapRightWithLeft(arr, left, right)
                left++
            } else {
                left++
            }
        }
        return arr
    }

    private fun swapRightWithLeft(arr: IntArray, left: Int, right: Int) {
        val temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
    }

}