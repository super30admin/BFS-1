// Time Complexity : O(V+E); where V = number of vertices and E = number of edges
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // intialize indegrees array to keep count of dependencies of each vertex
        int[] indegrees = new int[numCourses];
        
        // intialize adjacency list for efficient search (Independent Vertex, List of Dependent Vertices )
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        // fill the indegrees array and adjacency list
        for(int[] edge : prerequisites){
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
            
        }
        
        // initialize the count
         int count = 0;
        // traverse through the indegrees array and check for vertices which have no dependecies
        // add such nodes in queue and increment the count

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        
        // return false if queue is empty
        if(q.isEmpty()) return false;
        
        // traverse through the queue until it is not empty
        while(!q.isEmpty()){
            
            // pop element from queue
            int curr = q.poll();
            
            // get dependencies of cthe current element from the adjacency list
            List<Integer> children = map.get(curr);
                    
            if(children != null){
            // if dependencies are found,
            // then for each dependent vertex, reduce the value in indegrees array
                for(int child : children){
                    indegrees[child]--;
                    // check for its dependencies, if no dependencies are found,
                    // then add it to the queue and increment the count
                    if(indegrees[child] == 0){
                        q.add(child);
                        count++;
                    }
                }

            }
        }
        // if all the courses are taken, then return true 
        if(count == numCourses) return true;
        
        // else return false
        return false;
    }
}