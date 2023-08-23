package leetCode.arrayAndHashing

class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        if (nums.size == k) return nums

        val size = nums.size
        val bucketArr = MutableList<MutableSet<Int>?>(size){ null }
        val result = IntArray(k)
        var resultIndex = 0
        val count = mutableMapOf<Int, Int>()

        for (num in nums)
            count[num] = count.getOrDefault(num, 0) + 1


        for ((num, count) in count) {
            if (bucketArr[count] == null) bucketArr[count] = mutableSetOf()
            bucketArr[count]!!.add(num)
        }

        for (i in size-1 downTo 0) {
            if (bucketArr[i] != null) {
                for (value in bucketArr[i]!!) {
                    result[resultIndex] = value
                    resultIndex++
                    if (resultIndex == k) return result
                }
            }
        }
        return result
    }
}