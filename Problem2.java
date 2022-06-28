// Time Complexity : O(V+E) 
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//207. Course Schedule
//https://leetcode.com/problems/course-schedule/

class Problem2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        if (n == 1)
            return true;

        // making the indegree array
        int[] indegreeArr = new int[numCourses];
        for (int i = 0; i < n; i++) {
            indegreeArr[prerequisites[i][0]] += 1;
        }

        // making the adjacency list
        List<Integer>[] adj = new ArrayList[numCourses];

        for (int j = 0; j < n; j++) {
            if (adj[prerequisites[j][1]] == null) {
                adj[prerequisites[j][1]] = new ArrayList<Integer>();
                adj[prerequisites[j][1]].add(prerequisites[j][0]);
            } else {
                adj[prerequisites[j][1]].add(prerequisites[j][0]);
            }
        }

        // making queue and main logic
        // loop thru index array and check if any idex has zero in the array
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegreeArr[i] == 0) {
                q.add(i); // System.out.println("i " + i);
                count++;
            }
        }

        while (!q.isEmpty()) {
            int temp = q.remove();
            if (adj[temp] == null)
                continue;
            int size = adj[temp].size();
            for (int k = 0; k < size; k++) {
                indegreeArr[adj[temp].get(k)] -= 1;
                if (indegreeArr[adj[temp].get(k)] == 0) {
                    q.add(adj[temp].get(k));
                    count++;
                }
            }
        }
        if (count == numCourses)
            return true;
        else
            return false;

    }
}