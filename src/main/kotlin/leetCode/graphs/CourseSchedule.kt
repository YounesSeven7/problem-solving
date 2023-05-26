package leetCode.graphs

class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val map = mutableMapOf<Int, MutableList<Int>>()
        val cycleSet = mutableSetOf<Int>()
        val finishedCourses = mutableSetOf<Int>()
        val cycle = booleanArrayOf(false)

        for (intArr in prerequisites) {
            val (course, neededCourse) = intArr
            map.getOrPut(course) { mutableListOf() }.add(neededCourse)
        }

        for (course in map.keys) {
            dfs(course, map, cycleSet, cycle, finishedCourses)
        }
        if (cycle[0]) return false
         return true
    }

    fun dfs(course: Int,
            map: MutableMap<Int, MutableList<Int>>,
            cycleSet: MutableSet<Int>,
            cycle: BooleanArray,
            finishedCourse: MutableSet<Int>) {

        if (finishedCourse.contains(course)) return
        

        if (cycleSet.contains(course)) {
            cycle[0] = true
            return
        }

        cycleSet.add(course)

        if (!map.containsKey(course)) {
            finishedCourse.add(course)
            return
        }

        for (needCourse in map[course]!!) {
            dfs(needCourse, map, cycleSet, cycle, finishedCourse)
        }
        finishedCourse.add(course)
    }
}