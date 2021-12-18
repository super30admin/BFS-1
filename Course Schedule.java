// Time Complexity :O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int[] dependency = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
            dependency[prerequisites[i][0]]++;
        }
        for(int i =0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);             
         }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < dependency.length; i++){
            if(dependency[i] == 0){
                queue.add(i);
                
            }
            
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();
            list = map.get(curr);
            if(list!= null){
            for(int i = 0; i < list.size(); i++){
                dependency[list.get(i)]--;
                if(dependency[list.get(i)] == 0){
                    queue.add(list.get(i));
                }
            }
            
        }}
        for(int i = 0; i< numCourses; i++){
            if(dependency[i]!=0){
                return false;
            }
        }
        
        
        return true;      
        }
}