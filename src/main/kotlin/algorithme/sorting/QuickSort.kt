package algorithme.sorting

class QuickSort {
     fun sortThis(array: IntArray, start: Int, end: Int) {
        sort(array, 0, array.size-1)
    }

    fun sort(array: IntArray, start: Int, end: Int) {
        if (start >= end) {
            return
        } else {
            val p = partition(array, start, end)
            sortThis(array, start, p-1)
            sortThis(array, p+1, end)
        }
    }

    private fun partition(array: IntArray, start: Int, end: Int): Int {
        var arr = array
        val pivot = arr[start]
        var left = start + 1
        var right = end
        while (true) {
            while (left <= right && arr[left] < pivot) left++
            while (left <= right && arr[right] > pivot) right--
            if (left <= right)
                arr = swapRightWithLeft(arr, left, right)
            else
                break
        }
        arr = swapRightWithLeft(arr, start, right)
        return right
    }

    private fun swapRightWithLeft(arr: IntArray, left: Int, right: Int) :IntArray {
        val temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
        return arr
    }
}