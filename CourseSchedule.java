// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(V + E) where V is number of vertices and E stands for number of edges
//Space Complexity: O(n) since we are using extra space in terms of additional queues, indegrees array and HashMap 
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] edge : prerequisites)
        {
            int in = edge[0];
            int out = edge[1];
            
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
            indegrees[in]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        //checking for independent nodes
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] == 0)
            {
                q.add(i);
            }
        }
        
        if(q.isEmpty()) return false;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            if(map.get(curr) == null) continue;
            //Reduce the dependencies of the courses 
            for(int k : map.get(curr)){
                indegrees[k]--;
                if(indegrees[k] == 0){
                    q.add(k);
                }
            }
        }
        
        // verify if all the indegrees become zero
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] > 0) return false;
        }
        
        return true;
    }
}