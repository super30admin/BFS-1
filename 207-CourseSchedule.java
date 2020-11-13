/**LC-207
 * Time Complexity : O(V+E) 
 * Space Complexity : Not sure 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
 1. Calculate the indegrees of all the vertices(maintain in an array). The one having 0 indegrees are the independent nodes. 
 2. Create a hashmap: key: (node) value: (the nodes depended of the key)
 2. Put independent nodes (by checking indegrees array) inside the Queue.
 3. While q is non-empty
    4. poll element
    5. get the nodes which are affected by the poll element. (from hashmap)
    6. For those children, decrement their indegree by 1 in the indegrees array
    7. If any indegree becomes 0, add the respective node inside the queue.
8. If all indegrees are 0 return true. Else False;
 */ 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegrees = new int[numCourses];
        int flag = 0;
        
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < prerequisites.length; i++){
            
            if(!adjacencyList.containsKey(prerequisites[i][1]))
                adjacencyList.put(prerequisites[i][1], new ArrayList<>());
            adjacencyList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            
            
            indegrees[prerequisites[i][0]]++;
        }
        
        for(int i= 0; i<indegrees.length; i++){  //check all independent nodes and add to the queue
            if(indegrees[i] == 0){
                q.add(i);
            }   
        }
       
        while(!q.isEmpty()){
            
            int curr = q.poll();
            List<Integer> children = adjacencyList.get(curr);
            if(children != null){
                for(int child:children){
                
                    indegrees[child]--;
                    if(indegrees[child] == 0){
                        q.add(child);
                    }
                }
            }
            
        }
         for(int i= 0; i<indegrees.length; i++){
                if(indegrees[i] != 0){
                    return false;
                }   
            }
        return true;
        
    }
}