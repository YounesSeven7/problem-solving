package leetCode.advancedGraphs

class ReconstructItinerary {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val res = mutableListOf<String>()
        val map = HashMap<String, MutableList<String>>()

        for (itinerary in tickets)
            map.getOrPut(itinerary[0]) { mutableListOf() } += itinerary[1]
        for (list in map.values) list.sort()

        fun recursion(cityName: String) {
            res.add(cityName)
            if (map[cityName] == null) return

            val list = map.get(cityName)!!
            for (i in list.indices) {
                val currentCity = list[i]
                if (list[i] == "") continue
                list[i] = ""
                recursion(currentCity)
                if (res.size == tickets.size + 1) return
                res.removeAt(res.lastIndex)
                list[i] = currentCity
            }
        }
        recursion("JFK")
        return res
    }
}