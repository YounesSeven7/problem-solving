package leetCode.heaps

import java.util.PriorityQueue

class DesignTwitter {
    var count = 0
    val followMap = mutableMapOf<Int, MutableSet<Int>>()
    val tweetsMap = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()



    fun postTweet(userId: Int, tweetId: Int) {
        if (tweetsMap.containsKey(userId))
            tweetsMap[userId]!!.add(Pair(count, tweetId))
        else
            tweetsMap[userId] = mutableListOf(Pair(count, tweetId))
        count++
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val heap = PriorityQueue<Pair<Int, Int>>{a,b -> b.first-a.first}
        if (tweetsMap[userId] != null) {
            for (pair in tweetsMap[userId]!!)
                heap.add(pair)
        }
        if (followMap[userId] != null) {
            for (followeeId in followMap[userId]!!)
                if (tweetsMap[followeeId] != null)
                    for (pair in tweetsMap[followeeId]!!)
                        heap.add(pair)


        }

        val list = mutableListOf<Int>()
        while (list.size < 10 && heap.isNotEmpty()) {
            list.add(heap.remove().second)
        }
        return list
    }

    fun follow(followerId: Int, followeeId: Int) {
        if (followMap.containsKey(followerId))
            followMap[followerId]!!.add(followeeId)
        else
            followMap[followerId] = mutableSetOf(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
            followMap[followerId]?.remove(followeeId)
    }
}