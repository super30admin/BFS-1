// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {

        int[] inDegree = new int[numCourses];

        HashMap<Integer, List<Integer>> pre = new HashMap<>();

        // filling the inDegree and map
        for (int[] x : prereq) {
            int to = x[1];
            int from = x[0];

            inDegree[to] += 1;
            if (!pre.containsKey(from))
                pre.put(from, new ArrayList<>());

            pre.get(from).add(to);

        }

        Queue<Integer> q = new LinkedList<>();

        // taking all the courses with no prerequistes
        for (int x = 0; x < numCourses; x++) {
            if (inDegree[x] == 0)
                q.add(x);
        }

        // taking courses whose prerequisted are the course we already took
        while (!q.isEmpty()) {
            int front = q.poll();
            if (pre.containsKey(front)) {
                for (int x : pre.get(front)) {
                    inDegree[x] -= 1;
                    if (inDegree[x] == 0) {
                        q.add(x);
                    }
                }
            }
        }

        // check if any course remains
        for (int x : inDegree) {
            if (x != 0)
                return false;
        }

        return true;

    }
}