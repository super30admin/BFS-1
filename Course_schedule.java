TC: O(n)
SC: O(n)

Runtime: 29 ms
Memory Usage: 44.8 MB
Submitted: 4 minutes ago




class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] degrees = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< prerequisites.length; i++){
            degrees[prerequisites[i][0]]++;
        }
         for(int i=0; i< degrees.length; i++){
            if(degrees[i]==0){
                queue.add(i);
            }
         }   
        
         while(!queue.isEmpty() ) {
             
             int course  = queue.poll();
             
             for(int i=0; i<prerequisites.length; i++){
                 if(prerequisites[i][1]==course){
                     degrees[prerequisites[i][0]]--;
                 
                 if(degrees[prerequisites[i][0]] == 0){
                     queue.add(prerequisites[i][0]);
                 }
             }
             
         }  
             
         }
        for(int i=0; i< degrees.length; i++){
            if(degrees[i]!=0) return false;
        }
        return true;
        
    }
}
