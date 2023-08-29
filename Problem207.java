// Time Complexity : O(n)  
// Space Complexity : O(V+E) // V is no.of vertices that are in Hashmap
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites== null ||prerequisites.length==0) return true;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int[] dependency = new int[numCourses];

        for(int[] pr : prerequisites){
            dependency[pr[0]]++;

            if(!map.containsKey(pr[1]))
            {
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count=0;
         for(int i=0; i<dependency.length;i++)
         {
             if(dependency[i] ==0){
             queue.add(i);
            count++;
             }
         }
     if(queue.isEmpty()) return false ;
         while(!queue.isEmpty()){
             int curr = queue.poll();
             List<Integer> li = map.get(curr );
             if(li!=null){
             for(Integer i : li){
                 dependency[i]--;
                 if(dependency[i]==0){
                     queue.add(i);
                     count++;
                 }
                 if(count == numCourses)  return true;
             }
         }    
         }    
        return false;
        
    }
}