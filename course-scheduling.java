// TC: O(N+E)
// SC: O(N+E)


// Approach: finding cycle in DAG
  
  class Solution {
    int[] vis;
    int[] dfsVis;
    ArrayList<ArrayList<Integer>> adj;
    // int[] indegree = new int[numCourses];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //DFS
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
        
        // BFS
//         int[] indegree = new int[numCourses];
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
//         for(int i=0;i<numCourses;i++) {
//             adj.add(new ArrayList<>());
//         }
         
//         for(int i=0;i<prerequisites.length;i++) {
//             indegree[prerequisites[i][0]]++;
//             adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
//         }
        
//         // System.out.println(Arrays.toString(indegree));
//         Queue<Integer> queue = new LinkedList<>();
//         for(int i=0;i<numCourses;i++) {
//             if(indegree[i] == 0) {
//                 queue.add(i);
//             }
//         }
        
//         int count = 0;
//         while(!queue.isEmpty()) {
//             int curr = queue.poll();
//             count++;
//             for(int it: adj.get(curr)) {
//                 indegree[it]--;
//                 if(indegree[it] == 0) {
//                     queue.add(it);
//                 }
//             }
//         }
//         if(count == numCourses) return true;
//         return false;
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
