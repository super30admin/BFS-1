class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] visited = new int[numCourses];

        for(int i = 0; i<numCourses; i++){
            if(visited[i] == 0 && dfs(graph, i, visited)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int node, int[] visited){
        if(visited[node] == 1){
            return true;
        }
        if(visited[node] == 2){
            return false;
        }
        visited[node] = 1;

        for(int neighbor : graph.get(node)){
            if(dfs(graph, neighbor, visited)){
                return true;
            }
        }
        visited[node] = 2;
        return false;
    }
}

// Time Complexity: O(V + E) -> Processing all vertices and edges in the graph.
// Space Complexity: O(V + E) -> Storing adjacency list and in-degree array.
