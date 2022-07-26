class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return false;
        
        //indegrees array
        int[] indegrees = new int[numCourses];
        
        //Adj List
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] req : prerequisites){
            int in = req[0];
            int out = req[1];
            indegrees[in]++;
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        
        //BFS
        int completedCourses = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                completedCourses++;
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            
            if(edges == null) continue;
            for(int edge : edges){
                indegrees[edge]--;
                if(indegrees[edge] == 0){
                    q.add(edge);
                    completedCourses++;
                }
            }
        }
        // for(int i = 0; i < numCourses; i++){
        //     if(indegrees[i] != 0){
        //         return false;
        //     }
        // }
        return completedCourses == numCourses;
    }
}