package BFS-1;

public class problem2 {
    // Time Complexity : O(v+e) vertex, edge
// Space Complexity : O(v+e) vertex, edge
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        
        for(int[] edge : prerequisites){
            int in = edge[0];
            int out = edge[1];
            indegrees[in]++;
            if(!hm.containsKey(out)){
                hm.put(out, new ArrayList<>());
            }
            hm.get(out).add(in);
        }
        
        int courseCompleted = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++){
            if(indegrees[i] == 0){
                courseCompleted++;
                q.add(i);
            }
        }
        
        //start bfs
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> edges = hm.get(curr);
            if(edges != null){
                for(int edge : edges){
                    indegrees[edge]--;
                    if(indegrees[edge] == 0){
                        courseCompleted++;
                        q.add(edge);
                    }
                }
            }
        }
        
        return courseCompleted == numCourses;
    }
}
