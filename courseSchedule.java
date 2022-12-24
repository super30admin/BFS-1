// Time Complexity : O(V+E), V-> vertices and E-> Edges
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * We use BFS approach, we need to keep track of the courses dependency as in indegree or topological sort
 * Once we have indegrees array, we can remove the nodes with 0 dependency and check if there are any other courses which we have to, for this we keep a map to keep track of independent and dependent nodes,
 * We reduce the indegrees of those nodes by 1.
 * while doing this we keep a counter variable to keep track of number of courses added in the queue, if it matches with total course then we return true, saying the schedule is valid.
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : prerequisites) // O(E)
        {
            indegree[edge[0]]++;
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < indegree.length; i++) // O(V)
        {
            if (indegree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        if (count == 0)
            return false;

        while (!queue.isEmpty()) // O(V+E)
        {
            int num = queue.poll();

            // reduce indegree of all nodes depending on current
            List<Integer> children = map.get(num);

            if (children != null) {
                for (int child : children) {
                    indegree[child]--;

                    if (indegree[child] == 0) {
                        queue.add(child);
                        count++;
                    }
                }
            }
        }

        return count == numCourses;
    }
}