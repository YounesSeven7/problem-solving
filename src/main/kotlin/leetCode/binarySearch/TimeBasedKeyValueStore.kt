package leetCode.binarySearch

class TimeBasedKeyValueStore {
    val map = mutableMapOf<String, MutableList<Pair<String, Int>>>()
    fun set(key: String, value: String, timestamp: Int) {
        map.getOrPut(key) { mutableListOf() } += Pair(value, timestamp)

    }

    fun get(key: String, timestamp: Int): String {
        if (!map.containsKey(key)) return ""
        val list = map[key]!!
        var l = 0
        var r = list.size - 1
        var indexOfTimeStamp = -1
        while (l <= r) {
            val med = (l + r) / 2
            if (list[med].second > timestamp) {
                r = med - 1
            } else {
                l = med + 1
                indexOfTimeStamp = med
            }
        }
        return if (indexOfTimeStamp == -1) "" else list[indexOfTimeStamp].first
    }
}