package leetCode.daynamic_programing_second

class BestTimeToBuyAndSellStockWithCooldown {
    fun maxProfit(prices: IntArray): Int {
        var sold = 0
        var hold = Int.MIN_VALUE
        var rest = 0

        for (i in prices.indices) {
            val prevSold = sold
            sold = hold + prices[i]
            hold = maxOf(hold, rest - prices[i])
            rest = maxOf(rest, prevSold)
        }
        return maxOf(sold, rest)
    }
}