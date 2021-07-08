// Time Complexity : O(V+E)
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        
        int[] indegrees = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < prerequisites.length;i++){
            indegrees[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1]))
                map.put(prerequisites[i][1],new ArrayList<Integer>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }       
        for(int i = 0 ; i < indegrees.length ; i++){
           if(indegrees[i] == 0)  
              queue.add(i);  
        }
        while(!queue.isEmpty()){
              int course = queue.poll();
              List<Integer> list = map.get(course);
               if(list != null){
                   for(int element : list){
                      indegrees[element]--;
                      if(indegrees[element] == 0)
                       queue.add(element);
                   }
               }        
        }
        
        for(int i = 0; i < indegrees.length ; i ++){
            if(indegrees[i] != 0)
                return false;
        }
        
        return true;
    }
}