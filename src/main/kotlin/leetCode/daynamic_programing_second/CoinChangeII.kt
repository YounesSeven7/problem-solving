package leetCode.daynamic_programing_second

class CoinChangeII {
    fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1)
        dp[0] = 1
        for (num in coins)
            for (amount in 1..amount)
                if (amount - num >= 0)
                    dp[amount] += dp[amount - num]
        return dp[amount]
    }
}