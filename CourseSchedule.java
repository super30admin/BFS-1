// Time Complexity : O(V + E) V = number of courses, E = number of prerequistes
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int [] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> graph = new HashMap();
        
        for(int preq[]: prerequisites){
            
            int start = preq[1], end = preq[0];
            indegrees[end]++;
            
            if(!graph.containsKey(start)){
                graph.put(start, new ArrayList());
            }
            graph.get(start).add(end);
        }
        
        Queue<Integer> queue = new LinkedList();
        int count = 0;
        
        for(int i = 0;i < indegrees.length ; i++){
            if(indegrees[i] == 0)   queue.offer(i);
        }
        
        while(!queue.isEmpty()){
            
            int course = queue.poll();
            
            if(graph.containsKey(course)){
                for(int preq : graph.get(course)){
                    if ( --indegrees[preq] == 0){
                        queue.offer(preq);
                    }
                }
            }
            
            count++;
            
        }
        
        return count == numCourses;
    }
}
