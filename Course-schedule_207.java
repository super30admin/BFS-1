// Time Complexity : O(N) where N is number of nodes
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Find the in_degree count and apply topologial sort (start bfs from 0 in degree and remove it from graph). If its DAG then it will cover all nodes else not

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //adj list
        HashMap<Integer, List<Integer>> graph =  new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int[] entry : prerequisites) {
            List<Integer> edges = graph.getOrDefault(entry[1], new ArrayList<Integer>());
            edges.add(entry[0]);
            graph.put(entry[1], edges);
            inDegree[entry[0]]++;
        }


        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = q.size();
        if (count==0) return false;
        while(!q.isEmpty()) {

            List<Integer> edges = graph.get(q.remove());
            if(edges == null) continue;
            for(int n : edges) {
                inDegree[n]--;
                if (inDegree[n] == 0) {
                    q.add(n);
                    count++;
                }
            }
        }
        return count==numCourses;


    }
}
