package leetCode.medium.slidingWindow

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var leftPointer = 0
        var rightPointer = height.size - 1
        var globalSum = 0
        var localSum = 0
        while (leftPointer < rightPointer) {
            localSum = (Math.min(height[leftPointer], height[rightPointer])) * (rightPointer - leftPointer)
            globalSum = Math.max(globalSum, localSum)
            if (height[leftPointer] < height[rightPointer])
                leftPointer++
            else
                rightPointer--
        }
        return globalSum
    }
}