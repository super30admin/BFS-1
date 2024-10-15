// Time Complexity : 0(N+P)
// Space Complexity : 0(N+P)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] pr : prerequisites) {
            indegrees[pr[0]]++;
            if (!map.containsKey(pr[1])) {
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]);
        }

        
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                count++;
            }

        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> dependents = map.get(curr);
            if (dependents != null) {
                for (int dependent : dependents) {
                    indegrees[dependent]--;
                    if (indegrees[dependent] == 0) {
                        q.add(dependent);
                        count++;
                    }
                }
            }
        }
        if (count == numCourses)
            return true;
        return false;
    }
}