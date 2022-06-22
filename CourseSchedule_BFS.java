/* Time Complexity : O(V+E), V-Vertices, E-Edges
 * Space Complexity : O(V+E), V-Vertices, E-Edges
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //null
        if(prerequisites == null || prerequisites.length == 0) return true;
        int [] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int [] edge: prerequisites){ // O(E)
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            //reduce indegrees of dependent nodes
            List<Integer> li = map.get(curr);
            if(li != null){
                for(int edge: li){ // O(V+E)
                    indegrees[edge]--;
                    if(indegrees[edge] == 0){
                        q.add(edge);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }
        return false;
    }
}
