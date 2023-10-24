//T.C-O(V+E)
//S.C-O(V+E)
//passed all test cases on leetcode
//the approach is to use topological sorting by maintaining a indegree array and check wheather we can take all courses or not.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        int n = prerequisites.length;
        List<List<Integer>> al = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            indegree[prerequisites[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
            al.add(new ArrayList<Integer>());
        }
        if (q.size() == numCourses)
            return true;
        if (q.size() == 0)
            return false;
        for (int i = 0; i < n; i++) {
            al.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            int x = q.poll();
            for (int i = 0; i < al.get(x).size(); i++) {
                indegree[al.get(x).get(i)]--;
                if (indegree[al.get(x).get(i)] == 0) {
                    q.add(al.get(x).get(i));
                }
            }
        }
        return count == numCourses;
    }
}
