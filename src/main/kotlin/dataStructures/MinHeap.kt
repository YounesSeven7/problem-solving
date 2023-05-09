package dataStructures

class MinHeap(val list: ArrayList<Int>) {



    fun build() {
        for (i in (list.size-1) downTo 0)
            siftDown(i)
    }

    fun insert(number: Int) {
        list.add(number)
        siftUp(list.size-1)
    }

    fun getMin(): Int {
        return if (list.isNotEmpty()) list[0] else -1
    }

    fun removeMin(): Int {
        if (list.isEmpty()) return -1

        val min = list[0]
        list[0] = list[list.size-1]
        list.removeAt(list.size-1)
        siftDown(0)

        return min
    }

    fun update(index: Int, newValue: Int) {
        val oldValue = list[index]
        list[index] = newValue

        if (newValue < oldValue)
            siftUp(index)
        else if (newValue > oldValue)
            siftDown(index)
    }

    private fun siftUp(index: Int) {
        var i = index
        var parent = (i-1)/2
        while (i != 0 && list[i] < list[parent]) {
            val temp = list[parent]
            list[parent] = list[i]
            list[i] = temp

            i = parent
            parent = (i-1)/2
        }
    }

    private fun siftDown(index: Int) {
        var i = index
        var left = 2 * i + 1
        var right = 2 * i + 2
        while (
            (left < list.size && list[left] < list[i]) ||
            (right < list.size && list[right] < list[i])
        ) {
            var smallest = if (right >= list.size || list[left] <= list[right]) left else right

            val temp = list[smallest]
            list[smallest] = list[i]
            list[i] = temp

            i = smallest
            left = 2 * i + 1
            right = 2 * i + 2
        }
    }

}