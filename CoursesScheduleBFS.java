// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

public class CoursesScheduleBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for (int i = 0; i < n; i++) {
            int ind = prerequisites[i][1];
            int dep = prerequisites[i][0];
            indegrees[dep]++;

            if (!map.containsKey(ind)) {
                map.put(ind, new ArrayList<>());
            }
            map.get(ind).add(dep);
        }

        int count = 0;
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
            List<Integer> depList = map.get(curr);
            if (depList == null) continue;
            for (int dep : depList) {
                indegrees[dep]--;
                if (indegrees[dep] == 0) {
                    queue.add(dep);
                    count++;
                    if (count == numCourses) return true;
                }
            }
        }
        return false;
    }
}
