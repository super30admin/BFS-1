/**
Time complexity: O(V+E)
Space complexity: O(V+E)
Execute successfully on Leetcode: Yes
Any problems faced: No
*/
class Solution {
    /**
    Approach:
    - Create an indegree array that contains the number of edges coming into each node.
    - Create a map which contains the course to be completed as key and the prerequiste courses list as the value
    - Create a queue and add the course whose indegree is 0 to this queue.
    - Start the bfs by polling the queue:
      * Here, we process the courses in the prerequisite list and see if the dependencies for those courses have been met.
    - Eventually, we return true if all elements in the indegree array are 0. else, false.
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) {
            return true;
        }
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: prerequisites) {
            indegree[edge[0]]++;
            if(!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if(edges != null) {
                for(int edge: edges) {
                    indegree[edge]--;
                    if(indegree[edge] == 0) {
                        q.add(edge);
                    }
                }
            }
        }
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
