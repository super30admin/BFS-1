// Time Complexity :O(V+E)
// Space Complexity :O(V+E)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//This happens to be a directed graph question where we have to check if there exists a cycle in our graph.
// Here we maintain a HashMap as the Adjacency List.
//We add the vertices to our Adjacency list as the keys and the edges are stored in a list in the map as values to the keys.
//we also maintain an array called indegrees.This array is to check the occurences of the courses in our map.
//In order to detect the cycle in this graph, we check one key value pair and decrement the indegrees array per that.
//when the value of the indegrees array become zero , we add that vertex to our queue and perform a BFS.We cannot add the indegree value that is not zero.
//If that value is more than zero, it indicates a cycle in the graph.

//TC:O(V+E)
//SC:O(V+E)

//BFS solution
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int total = 0;
        int [] indegrees =  new int[numCourses];
        for(int[] edge : prerequisites){
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        for(int i =0;i<indegrees.length;i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            total++;
            List<Integer> depCourses = map.get(curr);
            if(depCourses != null){
                for(int edge : depCourses){
                    indegrees[edge]--;
                    if(indegrees[edge] == 0){
                        q.add(edge);
                    }
                }
            }
        }
        return total == numCourses;
    }
}