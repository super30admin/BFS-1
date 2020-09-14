// Time Complexity : O(E + V) V:numeber of course E: dependencies
// Space Complexity : O(E + V)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// Iterative BFS

class Solution {
// *************** BSF Topological sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
            inDegree.put(i, 0);
        }
        
        for (int[] course : prerequisites) {
            graph.get(course[1]).add(course[0]);
            inDegree.put(course[0], inDegree.get(course[0]) + 1);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int key : graph.keySet()) {
            if (inDegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        
        int count=0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i< size; i++){
                int vertex = queue.poll();
                count++;
                for(int child : graph.get(vertex)){
                    inDegree.put(child, inDegree.get(child)-1);
                    if(inDegree.get(child)==0){
                        queue.add(child);
                    }
                }
            }
        }
        return count == numCourses; 
    }
}