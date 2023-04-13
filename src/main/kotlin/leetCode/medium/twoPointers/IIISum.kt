package leetCode.medium.twoPointers


class IIISum {

    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        var firstNum = 0
        var secondNum = 0
        var thirdNum = 0
        var index = 0
        val list = ArrayList<ArrayList<Int>>()
        while (index < nums.size - 2) {
            firstNum = nums[index]

            var leftPointer = index+1
            var rightPointer = nums.size-1

            while (leftPointer < rightPointer) {
                secondNum = nums[leftPointer]
                thirdNum = nums[rightPointer]
                val sum = firstNum + secondNum + thirdNum
                if(sum  == 0) {
                    list.add(arrayListOf(firstNum, secondNum, thirdNum))
                    if (firstNum == 0 && secondNum == 0 && thirdNum == 0)
                        break
                    while (leftPointer < rightPointer && secondNum == nums[leftPointer]) leftPointer++

                } else if (sum < 0)
                    leftPointer++
                else
                    rightPointer--

                if (leftPointer == rightPointer)
                    break
            }
            while (index < nums.size && firstNum == nums[index]) index++
        }
        return list
    }
}