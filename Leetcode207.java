// Solution - Topological Sort using BFS
// TC: O(V + E) where V is number of courses and E is number of prerequisites
// SC: O(V + E) for storing the graph and in-degrees
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] inDegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int totalCoursePresent = 0;
        for (int[] pre : prerequisites) {
            int dep = pre[0];
            int indep = pre[1];

            if (!map.containsKey(indep)) {
                map.put(indep, new ArrayList<>());
            }
            map.get(indep).add(dep);
            inDegrees[dep]++;
            totalCoursePresent++;

        }
        if (totalCoursePresent == 0)
            return true;

        Queue<Integer> q = new LinkedList<>();
        int courseTaken = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
                courseTaken++;
            }
        }
        if (q.isEmpty())
            return false;

        while (!q.isEmpty()) {
            int size = q.size();
            int curr = q.poll();
            List<Integer> currDeps = map.get(curr);
            if (currDeps != null) {
                for (int dep : currDeps) {
                    inDegrees[dep]--;
                    if (inDegrees[dep] == 0) {
                        q.add(dep);
                        courseTaken++;
                        if (numCourses == courseTaken)
                            return true;
                    }
                }
            }
        }
        return false;

    }
}