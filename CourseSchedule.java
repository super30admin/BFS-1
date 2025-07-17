// TC: O (V + E)
// SC: O (V + E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }

        int[] indegree = new int[numCourses];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] pre: prerequisites) {
            int from = pre[1];
            int to = pre[0];

            indegree[to]++;

            if(!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                count++;
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int course = q.poll();
            List<Integer> dependents = map.get(course);

            if (dependents == null) {
                continue;
            }
            for (int dep : dependents) {
                indegree[dep]--;
                if (indegree[dep] == 0) {
                    q.add(dep);
                    count++;
                }
            }
        }

        return count == numCourses;
    }
}