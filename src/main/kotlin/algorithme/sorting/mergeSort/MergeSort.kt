package algorithme.sorting.mergeSort

class MergeSort {

    fun sortThis(arr: IntArray): IntArray {
        return sort(arr)
    }

    private fun sort(arr: IntArray): IntArray {
        if (arr.size == 1)
            return arr.copyOfRange(0, 1)
        val med = (arr.size-1) / 2
        val leftArr = sort(arr.copyOfRange(0, med+1))
        val rightArr = sort(arr.copyOfRange(med+1, arr.size))
        return merge(leftArr, rightArr)
    }

    private fun merge(leftArr: IntArray, rightArr: IntArray): IntArray {
        var leftIndex = 0
        var leftValue = 0
        val ls = leftArr.size

        var rightIndex = 0
        var rightValue = 0
        val rs = rightArr.size

        val arr = IntArray(ls + rs)
        var index = 0

        while (leftIndex < ls && rightIndex < rs) {
            leftValue = leftArr[leftIndex]
            rightValue = rightArr[rightIndex]
            if (leftValue < rightValue) {
                arr[index] = leftValue
                leftIndex++
            } else {
                arr[index] = rightValue
                rightIndex++
            }
            index++
        }

        while (leftIndex < ls) {
            leftValue = leftArr[leftIndex]
            arr[index] = leftValue
            leftIndex++
            index++
        }

        while (rightIndex < rs) {
            rightValue = rightArr[rightIndex]
            arr[index] = rightValue
            rightIndex++
            index++
        }
        return arr
    }
}