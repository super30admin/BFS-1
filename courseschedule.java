// TC :O(V+E)
// SC :O(V+E) where V and E are vertices and edges of the graph representing the soltion.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses ==0) return true;
        //indegrees array
        int[] indegrees = new int[numCourses];
        //adjacency list
        HashMap<Integer,List<Integer>> map = new HashMap<>();     
        for(int[] req : prerequisites){
            int in = req[0];
            int out = req[1];
            indegrees[in]++;
            if(!map.containsKey(out)){
                map.put(out,new ArrayList<>());
            }
            map.get(out).add(in);
        }
        
        //BFS
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if(edges == null) continue;
            for(int edge : edges){
                indegrees[edge]--;
                if(indegrees[edge]==0){
                    q.add(edge);
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]!=0){
                return false;
            }
        }
        
        return true;
        
    }
}