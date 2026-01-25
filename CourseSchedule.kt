// In this problem, we need to determine if we can complete all courses with given prerequisites. We create adjacency list to represent the graph and an indegree array to track the number of 
// prerequisites for each course. We use a queue to perform a topological sort. We start by adding all courses that have zero indegree to the queue. 
//Then we process each course in the queue by reducing the indregree of its dependent courses. If any dependent course's indegree becomes zero, we add it to the queue.
// Time complexity is O(V + E) where V is no. of courses and E is no. of prerequisites. Space complexity is O(V + E) for adjacency list and indegree array.

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adj = Array(numCourses){mutableListOf<Int>()}
        val indegree = IntArray(numCourses)

        for(p in prerequisites) {
            val c = p[0]
            val pre = p[1]
            adj[pre].add(c)
            indegree[c]++
        }

        val q : ArrayDeque<Int> = ArrayDeque()
        for(i in 0 until numCourses) {
            if(indegree[i] == 0) {
                q.addLast(i)
            }
        }

        var seen = 0
        while(q.isNotEmpty()) {
            val u = q.removeFirst()
            seen++

            for(v in adj[u]) {
                if(--indegree[v] == 0) {
                    q.addLast(v)
                }
            }
        }
        return seen == numCourses
    }
}