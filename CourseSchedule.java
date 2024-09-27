// Time Complexity : O(n) 
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] incomingEdges = new int[numCourses];
        HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
        
        for(int[] edges : prerequisites){
            int first = edges[0];
            int second = edges[1];
            
            incomingEdges[first]+=1;
        
            if(!hashmap.containsKey(second)){
                hashmap.put(second, new ArrayList<>());
                System.out.println("here");
            }
                hashmap.get(second).add(first);
        }
        
        Queue<Integer> queue = new LinkedList();
    
        for(int i=0;i<incomingEdges.length;i++){
             if(incomingEdges[i]==0){
                 queue.add(i);
             }
         }
        
        if(queue.isEmpty()){
            return false;
        }
        
        while(!queue.isEmpty()){
            int front = queue.poll();
             if(!hashmap.isEmpty()){
                if(hashmap.containsKey(front)){
                    for(int x: hashmap.get(front)){
                        incomingEdges[x]-=1;
                        if(incomingEdges[x]==0){
                            queue.add(x);
                        }
                     }
                  }
                }
        }
        
        for(int x: incomingEdges){
            if(x!=0){
                return false;
            }
        }
         return true;
    }
}