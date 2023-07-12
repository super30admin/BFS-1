// Time Complexity : O(n2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    boolean[] path; 
    boolean[] visited; 
    boolean hasCycle = false; //final result
    Map<Integer, List<Integer>> mp; //the graph
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        path = new boolean[n + 1];
        visited = new boolean[n + 1];
        mp = new HashMap<>(); //initialize
        buildGraph(prerequisites); // build grapth
        for(int i = 0; i < numCourses; i++) { //traverse each node
            traverse(mp, i);
        }
        return !hasCycle; //result
    }

    public void traverse(Map<Integer, List<Integer>> mp, int idx) {
        if(path[idx]) {   //if current node was found in path array
                        // there must be a cycle
            hasCycle = true;
        }
        
        if(hasCycle || visited[idx]) return; 
        
        visited[idx] = true;
        path[idx] = true; //we do backtracking here to try all possible path
        if(mp.get(idx) != null) { //traverse
            for(int i : mp.get(idx)) {
                    traverse(mp, i);
                }
        }
        

        path[idx] = false; //backtracking ended
    }

    public void buildGraph(int[][] prerequisites) {
        
        for(int[] i : prerequisites) {
            if(!mp.containsKey(i[1])) {
                mp.put(i[1], new ArrayList<>());
            }
            mp.get(i[1]).add(i[0]); // pre => cur, cur relys on pre courses
        }
    }
}