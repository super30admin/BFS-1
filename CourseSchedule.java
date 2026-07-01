import java.util.*;

class Solution {
    /* 
        TC - O(V + E)
        SC - O(V + E)

        A HashMap is used to build a graph where each course points to the courses that depend on it.
        An indegree array stores the number of prerequisites for each course.
        All courses with 0 prerequisites are added to a queue since they can be taken immediately.
        The algorithm repeatedly removes a course from the queue, marks it as completed, 
        and reduces the indegree of its dependent courses. If any dependent course's indegree becomes 0, 
        it is added to the queue. If all numCourses are processed, there is no cycle, so all courses can 
        be finished. Otherwise, a cycle exists, making it impossible to complete all courses.
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int de = prerequisite[0];
            int in = prerequisite[1];
            indegrees[de]++;
            if (!map.containsKey(in)) {
                map.put(in, new ArrayList<>());
            }
            map.get(in).add(de);
        }

        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        if (count == numCourses) return true;
        if (queue.isEmpty()) return false; 
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> children = map.get(curr);
                if (children != null) {
                    for (int child : children) {
                    indegrees[child]--;
                    if (indegrees[child] == 0) {
                        queue.add(child);
                        count++;
                        if (count == numCourses) return true;
                    }
                }
            }
        }

        return false;
    }
}