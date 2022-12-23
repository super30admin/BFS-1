// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int count = 0;
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        for(int[] edge : prerequisites){
            inDegree[edge[0]]++;
            if(!adjacencyMap.containsKey(edge[1])){
                adjacencyMap.put(edge[1], new ArrayList<>());
            }
            adjacencyMap.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            // Add all independent courses to the queue for processing
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int parent = queue.poll();
            count++;
            List<Integer> children = adjacencyMap.get(parent);
            if(children != null){
                for(int child : children){
                    inDegree[child]--;
                    if(inDegree[child] == 0){
                        queue.add(child);  
                    }                
                }
            }
        }
        return count == numCourses? true : false;
    }
}