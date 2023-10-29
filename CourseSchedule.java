
// Time Complexity :O(v+e)
// Space Complexity : O(v+e) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] indegrees = new int[numCourses];
     
    for(int[] pr: prerequisites){
        int out = pr[1];
        int in = pr[0];
        indegrees[in]++;
        
        if(!map.containsKey(out)){
            map.put(out, new ArrayList<>());
        }
        map.get(out).add(in);
    } 
        
    int count = 0;
    
    //To start add independed courses from indegrees    
    Queue<Integer> q = new LinkedList<>();
    for(int i= 0 ; i< numCourses; i++){
        if(indegrees[i] == 0){
            q.add(i);
            count ++;
        }
    }
    if(count == numCourses) return true;
    if(q.isEmpty()) return false;    
    
    //processing queue bfs
    while(!q.isEmpty()){
        int curr = q.poll();
        List<Integer> babies = map.get(curr);
        if(babies != null){
         for(int baby: babies){
           indegrees[baby]--;
        if(indegrees[baby]==0 ){
            q.add(baby);
            count ++; 
        }  
     }
        }
        
    }  
    return count == numCourses;       
        
    }
}
