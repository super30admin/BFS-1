// Time Complexity :O(V * E)
// Space Complexity :O(V + E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/*Approach:
* ----------> Applying topological sort using indegrees.
        Create a adjacent list(as edges are given) and 
            and also update indegree array representing dependency count.
        if indegree is 0 -> independent course.
    Apply BFS starting with ALL independent courses.
* 
*   Push all independent courses into queue based on indegree.
        Process each independent course dependencies by reducing the indegrees by 1.
    If indegree is 0, add to queue as independent course.
* 
*---------> If queue is empty and all indegrees are 0, return true.
    else, return false
    /* */

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
        
            int [] indegrees = new int[numCourses];
    
            for(int[] edge: prerequisites){
                int out = edge[1]; //independent
                int in = edge[0]; //dependent
                indegrees[in]++;
    
                if(!map.containsKey(out)){
                    map.put(out,    new ArrayList<>());
                }
    
                map.get(out).add(in);
            }
    
            Queue<Integer> q = new LinkedList<>();
            int count = 0;
    
            for(int i = 0; i < numCourses; i++){
                if(indegrees[i] == 0){
                    q.add(i);
                    count++;
                }
            }
    
            if(q.isEmpty()) return false;
            if(count == numCourses) return true;
            while(!q.isEmpty()){
                int curr = q.poll();
                List<Integer> children = map.get(curr);
                
                if(children != null){
                        for(int child : children){
                        indegrees[child]--;
                        if(indegrees[child] == 0){
                        q.add(child);
                        count++;
                        if(count == numCourses) return true;
                    }
                   }
                }
    
                
            }
    
            return false;
        }
    }
