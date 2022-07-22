//Time Complexity:O(V+E)
//Space Complexity :O(V+E)//Height of the tree using recursive stack+hashmap+path+visited
//Amazon Interview
//using hashmap for courses and courses requirement for satisfying prereq, will use 2 arrays, one for paths and 2nd array for visited or completed courses in boolean representing true or false.True means lies in the path which already gone completed the path and touched that cycle.once it done back it will revert to the path.DFS path it will check true then if will check from the true node.
class Solution {
    HashMap<Integer, List<Integer>> map;
    boolean[] visited;
    boolean[] path;
        
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        
        //adj list
        map = new HashMap<>();
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        
        for(int[] req: prerequisites){
            int in =req[1];
            int out = req[0];
            if(!map.containsKey(out)){
                map.put(out,new ArrayList<>());
            }
            map.get(out).add(in);
        }
        //DFS
        for(int i = 0;i<numCourses;i++){
            if(visited[i] == false && hasCycle(i)){
                return false;
            }
        }
        return true;
    }
    private boolean hasCycle(int u){
        //base
        if(path[u] == true) return true;
        if(visited[u] == true) return false;
        //logic//action
        path[u] = true;
        visited[u] = true;
        List<Integer> edges = map.get(u);
        if(edges != null){
            for(int edge: edges){
                //recurse
                if(hasCycle(edge)) return true;
            }
        }
        //backtrack
        path[u] = false;
        return false;
    }
}