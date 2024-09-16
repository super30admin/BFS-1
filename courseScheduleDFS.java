// sc and tc --> o( v + e)
class Solution {
    boolean[] path;
    boolean[] visited;
    HashMap<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        
        map = new HashMap<>();
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        
        //constructing adjacency list
        for(int[] edge : prerequisites) { 
            if(!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == false && hasCycle(i)) {
                return false;
            }
        }
        return true;
    }
    private boolean hasCycle(int course) {
        //base
        if(path[course]) {
            return true;
        }
        if(visited[course]) {
            return false;
        }
        
        //logic
        visited[course] = true;
        path[course] = true;
        
        List<Integer> edges = map.get(course);
        if(edges != null) {
            for(int edge : edges) {
                if(hasCycle(edge) == true) {
                    return true;
                }
            }
        }
        path[course] = false;
        return false;
    }
}