// Time Complexity :o(v+E)^2 - where v is numver of vertices and e is numberof edges
// Space Complexity : o(v+E) - implicit stack used while doing dfs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach : Brute force approach, for every node do dfs i.e explore all neighor path and and if while doing dfs we come back to starting node
// then there is a cycle and we return false
class Solution {

    Map<Integer, List<Integer>> map;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        generateGraph(numCourses,prerequisites);
        boolean res = true;
         for(int i = 0; i< numCourses; i++){
            res = res && detectCycle(i, i,new HashSet<>());
        }
        return res;
    }

    public boolean detectCycle(int start, int curr, Set<Integer> visited){

        if(!visited.isEmpty() && curr == start) return false;

        if(visited.contains(curr)) return true;

        visited.add(curr);

        boolean res = true;
        List<Integer> neighbors = map.get(curr);
        for(int neighbor : neighbors){
             res = res && detectCycle(start, neighbor, visited);
        }
        return res;
    }

    public void generateGraph(int nodes, int[][] edges){

        map = new HashMap<>();

        for(int i = 0; i< nodes; i++){
            map.put(i, new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
             map.get(edges[i][0]).add(edges[i][1]);
        }
    }


}
