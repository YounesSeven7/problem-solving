package leetCode.daynamic_programing_first

class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        val dp = IntArray(amount + 1)
        coins.sortDescending()
        fun recursion(remainingAmount: Int): Int {
            if (remainingAmount == 0) return 1
            if (remainingAmount < 0) return amount + 1
            if (dp[remainingAmount] != 0) return dp[remainingAmount] + 1
            var minCountOfCoin = amount + 1
            for (i in coins.indices) {
                minCountOfCoin = Math.min(minCountOfCoin, recursion(remainingAmount - coins[i]))
            }
            dp[remainingAmount] = minCountOfCoin
            if (minCountOfCoin == amount + 1) return minCountOfCoin else return minCountOfCoin + 1
        }
        recursion(amount)
        return if (dp[amount] == amount + 1) -1 else dp[amount]
    }


    fun coinChange2(coins: IntArray, amount: Int): Int {
        var res = Int.MAX_VALUE
        coins.sortDescending()
        fun recursion(remainingAmount: Int, howManyCoins: Int) {
            if (remainingAmount == 0) {
                res = Math.min(res, howManyCoins)
                return
            }
            if (remainingAmount < 0) return
            for (i in coins.indices) {
                recursion(remainingAmount - coins[i], howManyCoins + 1)
            }
        }
        recursion(amount, 0)
        print(res)
        return res
    }

}