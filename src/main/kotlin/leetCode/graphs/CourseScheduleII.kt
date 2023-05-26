package leetCode.graphs

class CourseScheduleII {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val nodes = mutableMapOf<Int, MutableList<Int>>()
        prerequisites.forEach {
            val (v, w) = it
            nodes.getOrPut(v) { mutableListOf<Int>() } += w
        }
        print(nodes)
        val map = mutableMapOf<Int, MutableList<Int>>()
        val cycleSet = mutableSetOf<Int>()
        val finishedCourses = mutableSetOf<Int>()
        val cycle = booleanArrayOf(false)
        val list = mutableListOf<Int>()

        for (intArr in prerequisites) {
            if (map.containsKey(intArr[0])) map[intArr[0]]!!.add(intArr[1])
            else map[intArr[0]] = mutableListOf(intArr[1])
            if (!map.containsKey(intArr[1])) map[intArr[1]] = mutableListOf()
        }

        for (course in 0 until numCourses) {
            if (!map.containsKey(course)) map[course] = mutableListOf()
        }

        for (course in map.keys) {
            dfs(course, map, cycleSet, cycle, finishedCourses, list)
        }
        if (cycle[0]) return intArrayOf()
        val array = IntArray(list.size)
        for (i in 0 until list.size) {
            array[i] = list[i]
        }
        if (map.keys.size == finishedCourses.size) return array
        return intArrayOf()
    }

    fun dfs(course: Int,
            map: MutableMap<Int, MutableList<Int>>,
            cycleSet: MutableSet<Int>,
            cycle: BooleanArray,
            finishedCourse: MutableSet<Int>,
            list: MutableList<Int>) {

        if (finishedCourse.contains(course)) return


        if (cycleSet.contains(course)) {
            cycle[0] = true
            return
        }

        cycleSet.add(course)

        for (needCourse in map[course]!!) {
            dfs(needCourse, map, cycleSet, cycle, finishedCourse, list)
        }
        finishedCourse.add(course)
        list.add(course)
    }
}