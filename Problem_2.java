/*
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * 
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<prerequisites.length; i++){
            indegrees[prerequisites[i][0]]++;
            
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<indegrees.length; i++){
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            
            int ele = queue.poll();
            if(map.get(ele) != null){
                
                List<Integer> children = map.get(ele);
                for(Integer child : children){
                    indegrees[child]--;
                    if(indegrees[child] == 0) queue.add(child);
                }
            }
        }
        
        for(int i = 0; i<numCourses; i++){
            if(indegrees[i] > 0){
                return false;
            }
        }
        
        return true;
    }
    
}