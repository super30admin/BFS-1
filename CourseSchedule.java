public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] edges) {
        // BFS Solution
        
        Map<Integer,List<Integer>> adjacency_list = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        // Prepare indegrees array and adjacency list
        for(int[] edge:edges){
            indegree[edge[0]]++;
            
            if(!adjacency_list.containsKey(edge[1])){
                adjacency_list.put(edge[1],new ArrayList<>()); // independent node to the dependent node
            }
            adjacency_list.get(edge[1]).add(edge[0]);
        }
        
        
        // BFS logic
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        // This loop finds all the root nodes (independent nodes whose indegree is 0)
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
                count++;
            }
        }
        if(count == numCourses) return true;
        while(!queue.isEmpty()) {
            // pop all the root nodes and decrease dependencies of their children by one
            int curr = queue.poll();
            List<Integer> children = adjacency_list.get(curr);
            if(children!=null){
                for(int child: children){
                    indegree[child]--;
                    if(indegree[child]==0){ // push the child into the queue if its indegree has become zero
                        queue.add(child);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }
     return false;
    }
}

// Time Complexity - O(V+E) [ V - Number of vertices, E - Number of Edges]
// Space Complexity - O(V+E)