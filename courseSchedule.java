// Time Complexity : O(N) where N=number of edges in the graph
// Space Complexity : O(N) where N=number of nodes in the graph
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int [] prerequisite: prerequisites){
            int in = prerequisite[0];
            int out = prerequisite[1];
            indegrees[in]++;
            if (!map.containsKey(out)){
                map.put(out,new ArrayList<>());
            }
            map.get(out).add(in);
        }   
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<indegrees.length;i++){
            if (indegrees[i] == 0){
                q.add(i);
            }
        }
        if(q.size() == 0) return false;
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            List<Integer> edges = map.get(curr);
            if(edges != null)
                for(int edge: edges){
                    indegrees[edge]--;
                    if(indegrees[edge] == 0) {
                        q.add(edge);
                    }
                }
        }
        if(count != numCourses) return false;
        return true;

    }
}

