import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We maintain an indegree array indicating dependency of course
// We perform BFS starting with independent course and at each step reducing the dependency
// For this we need to create adjacency list
// While performing BFS increment a counter and check this counter with numCourses
// counter indicates the finished courses 
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // null check
        if (prerequisites == null || prerequisites.length == 0)
            return true;

        int[] indegrees = new int[numCourses];
        // counstruct our adjacency list in form of hashmap
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prereq : prerequisites) {
            int in = prereq[0];
            int out = prereq[1];
            indegrees[in]++;
            if (!map.containsKey(out)) {
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }

        // from indegrees start with adding independent courses in queues for BFS
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }
        if (q.size() == 0)
            return false;

        int count = 0;
        // perform BFS and reduce indegree of that course by 1
        while (!q.isEmpty()) {
            count++;
            int curr = q.poll();
            List<Integer> childs = map.get(curr);
            if (childs != null) {
                for (int child : childs) {
                    indegrees[child]--;
                    if (indegrees[child] == 0) {
                        q.add(child);
                    }
                }
            }

        }
        return count == numCourses;
    }
}