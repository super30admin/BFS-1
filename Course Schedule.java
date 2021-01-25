//Time: O(V+E) V-> is vertex and E is edges;
//space: O(V+E) V-> is vertex and E is edges; in the HashMap at a vertex we add maximum corresponding edges 




class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        
        // Topo logical sort and increase the degree based on the dependent course
        int[] indegrees = new int[numCourses];
        
        // In HashMap add the independent courses as key and add the list of dependent courses as value. For example [2,0] Key should be 0 which is independent and 2 is dependent.
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        for(int[] edges: prerequisites){
            indegrees[edges[0]]++; // increase indegree
            if(!map.containsKey(edges[1])){
                map.put(edges[1], new ArrayList<>());                
               
            }
             map.get(edges[1]).add(edges[0]);      // add values to the map
        }
        
        Queue<Integer> q = new LinkedList<>();
        int count=0;
        
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i] ==0){ // Adding all the 0 values to the queue
                q.add(i); 
            }
        }
        if(q.isEmpty()) return false;
        
        
        while(!q.isEmpty()){
            int curr = q.poll();
            count++; // Increase the count as we are taking the course
            
            List<Integer> edges = map.get(curr);
            if(edges !=null){
                
                for(int edge: edges){
                    indegrees[edge]--; // reduce the degree to get 0 and then add to queue
                if(indegrees[edge]==0){
                    q.add(edge);
                }
                }
            }
            
        }
        
        if(count==numCourses){ // finally checking whether count is equal to number fo courses
            return true;
        } 
        
        return false;
        
    }
}
