// https://leetcode.com/problems/course-schedule/
// Time Complexity : O(V + E) where V is the number of courses and E is the number of prerequisites.
// Space Complexity : O(V + E) where V is the number of courses and E is the number of prerequisites.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> aList = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for (int[] pr : prerequisites) {
            indegrees[pr[0]]++;
            if (!aList.containsKey(pr[1])) {
                aList.put(pr[1], new ArrayList());
            }
            aList.get(pr[1]).add(pr[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int cnt = numCourses;
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                cnt--;
            }
        }
        if (cnt == 0)
            return true;
        if (q.isEmpty())
            return false;
        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> li = aList.get(curr);
            if (li != null) {
                for (int child : li) {
                    indegrees[child]--;
                    if (indegrees[child] == 0) {
                        q.add(child);
                        cnt--;
                        if (cnt == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        if (cnt == 0) {
            return true;
        }
        return false;
    }
}