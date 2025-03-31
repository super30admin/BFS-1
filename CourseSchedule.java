// Time Complexity : O(V+E)
// Space Complexity :O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int i = pre[0];
            int j = pre[1];
            adjList.get(j).add(i);
        }

        Queue<Integer> q = new LinkedList<>();

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int el : adjList.get(i)) {
                indegree[el]++;
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;

        while (!q.isEmpty()) {
            int idx = q.poll();
            cnt++;
            for (int el : adjList.get(idx)) {
                indegree[el]--;
                if (indegree[el] == 0) {
                    q.add(el);
                }
            }
        }

        return cnt == numCourses;

    }
}