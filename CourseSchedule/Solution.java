
// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Maintain an indegrees array indicating no. of incoming edges of each vertex. Maintain a hashmap of the edges (key: Vertex, Value: List
 * of vertices having key as the incoming vertex),
 * Add all courses in the queue having 0 incoming edge and increment count. Process those edges. Decrement the count of those vertices in the
 * indegrees array.
 * Do this process until there are no vertices with 0 incoming edge i.e count is 0 for a vertex.
 * Check if the count is equal to number of course. If yes, that means there is no cycle and you can fisih all courses. Return true,
 * else return false
 */

/**
 * Topological sort in a directed acyclic graph
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;

        for(int[] pr: prerequisites) { //O(E)

            indegrees[pr[0]]++;

            if(!map.containsKey(pr[1]))
                map.put(pr[1], new ArrayList<>());
            map.get(pr[1]).add(pr[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++) { //O(V)
            if(indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }

        if(count == numCourses) return true;

        while(!q.isEmpty()) { //O(V+E)

            Integer course = q.poll();
            List<Integer> list = map.get(course);

            if(list != null) {
                for(Integer i: list) {

                    indegrees[i]--;

                    if(indegrees[i] == 0) {
                        q.add(i);
                        count++;

                        if(count == numCourses) return true;
                    }
                }
            }
        }

        return false;
    }
}