//Time: O(V+E)
//Space: O(V+E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses]; 
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false;
            }    
        }
        return true;
    }
    private boolean dfs(ArrayList[] graph, int[] visited, int course) {
        if(visited[course] == 2)
            return true;
         
        
        if(visited[course] == 1)
            return false;
        
         visited[course] = 1;

         for (int i = 0; i < graph[course].size(); i++) {

              if (!dfs(graph, visited, (int)graph[course].get(i))) {
                return false;
            }
             
        }
        
        visited[course] = 2;
        return true;
    }
}
