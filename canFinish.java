// Time Complexity : O(V*E)
// Space Complexity : O(V+E) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if (prerequisites.length == 0)
            return true;
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int []indegree = new int[numCourses];
        boolean []vis = new boolean[numCourses];
        
        // build the graph first
        for (int[] relation : prerequisites) {

            if (graph.containsKey(relation[1])) {
                graph.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(relation[0]);
                graph.put(relation[1], nextCourses);
            }
            indegree[relation[0]]++;
        }

        // Add elemnst with indegree 0 to queue
        Queue<Integer> q = new LinkedList();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i]==0) { 
                q.add(i);
                vis[i] = true;
            }
        }        
        
        // Poll an element from queue
        // Reduce indegree of all its neighbours
        // if any indegree gets to 0 add to Q
        // repeat until Q is empty
        int c = 0;
        while(!q.isEmpty()) {
            
            int t = q.poll();
            c++;
            
            if(graph.containsKey(t))
                for(int n : graph.get(t)) {

                    if(!vis[n]) {
                        indegree[n]--;
                        if(indegree[n]==0) {
                            q.add(n);
                            vis[n] = true;
                        }
                    }
                }
            
        }
        
        // If we were able to visit all elements return true else false
        return c==numCourses;
        
    }
}
