// Time Complexity : O(E + V) E is the Edges and V is the Vertices
// Space Complexity : O(E + V) E is the Edges and V is the Vertices
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had difficulty in creating the graph


// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList();
        
        // create a graph
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList());
        }
        
        //create edges in the graph and count indegrees to a Node.
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        
        //find the indegrees zero and add them to the queue
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }
        
        Set<Integer> visited = new HashSet();
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            while(size-- > 0) {
                int temp = queue.poll();
                visited.add(temp);
                List<Integer> tempList = graph.get(temp);
                for(int i : tempList) {
                    if(--indegree[i] == 0 && !visited.contains(i))
                        queue.add(i);
                }
            }
        }
        
        return visited.size() == numCourses;
    }
}