// Time Complexity : O(N+E)
// Space Complexity : O(N+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int[] vis;
    int[] dfsVis;
    ArrayList<ArrayList<Integer>> adj;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        vis = new int[numCourses];
        dfsVis = new int[numCourses];
        adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++) {
            // indegree[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        System.out.println(adj);

        for(int i=0;i<numCourses;i++) {
          if(vis[i] == 0) {
            if(checkCycle(i)) {
                return false;
            }
          }
        }

        return true;
    }
    public boolean checkCycle(int i) {
        vis[i] = 1;
        dfsVis[i] = 1;

        for(int it : adj.get(i)) {
            if(vis[it] == 0) {
                if(checkCycle(it) == true) {
                    return true;
                }    
            } else if(dfsVis[it] == 1) {
                return true;
            } 
        }
        dfsVis[i] = 0;
        return false;
    }
}