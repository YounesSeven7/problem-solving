package leetCode.medium.slidingWindow

class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size == 1) return 0
        var leftPointer = 0
        var rightPointer = 1
        var max = 0
        while (rightPointer < prices.size) {
            if (prices[leftPointer] > prices[rightPointer]) {
                leftPointer = rightPointer
            }
            max = Math.max(max, prices[rightPointer]-prices[leftPointer])
            rightPointer++
        }
        return max
    }
}