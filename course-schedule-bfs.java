import java.util.*;

class Solution {
    // BFS Solution
    // Time complexity is O(V+E) i.e vertices + edges
    // Space complexity is O(V+E) // Please confirm if this is right space complexity
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //edge case
        if(numCourses == 0 || prerequisites.length == 0) return true;
        //Defining all needed data structures
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        // Preparing indegree and adjacency list
        for(int [] edges: prerequisites){
            indegree[edges[0]]++;
            if(!map.containsKey(edges[1])){
                map.put(edges[1],new ArrayList<>());
            }
            map.get(edges[1]).add(edges[0]);//if I complete edge[0], I can take edge[1]
        }
        for(int i = 0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        if(q.isEmpty()) return false; // This is an impossible course
        while(!q.isEmpty()){
            int temp = q.poll();
            List<Integer> list = map.get(temp);
            if(list !=null){
                for(int c: list){
                    indegree[c]--;
                    if(indegree[c] == 0){
                        q.add(c);
                    }
                }
            }
        }
        for(int i = 0;i<numCourses;i++){
            if(indegree[i] != 0){
                return false;
            }
        }
        return true;
    }
}