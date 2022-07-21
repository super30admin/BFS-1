//Time Complexity- O(V+E)
//Space Complexity- O(V)
//Sucessfully ran on leetcode


class Solution {
 public boolean canFinish(int numCourses, int[][] prerequisites) {
   if(numCourses==0) return true;
     
     int[] inDegree= new int[numCourses]; 
     HashMap<Integer, List<Integer>> map= new HashMap<>();
     
     for(int[] req : prerequisites){
         
         int in= req[0];
         int out= req[1];
         
         inDegree[in]++;
         
         if(!map.containsKey(out)){
             map.put(out, new ArrayList<>());
         }
         map.get(out).add(in);
     }
     
     Queue<Integer> q= new LinkedList<>();
     
     for(int i=0; i< numCourses; i++){
         if(inDegree[i]==0){
             q.add(i);
         }
     }
     
     while(!q.isEmpty()){
         
         int curr= q.poll();
          List<Integer> edges = map.get(curr);
         if(edges==null) continue;
         for(int edge : edges){
             
             inDegree[edge]--;
             if(inDegree[edge]==0){
                 q.add(edge);
             }
         }
     }
     for(int i= 0; i< numCourses; i++){
         if(inDegree[i]!=0){
             return false;
             
         }
     }
     return true;
 }
}