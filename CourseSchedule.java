// Time Complexity : O(N) n is number of array inprerequisits
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;

        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] edge : prerequisites){
            int in = edge[0];
            int out = edge[1];

            indegrees[in]++;
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<indegrees.length; i++) {
            if(indegrees[i] == 0){
                q.add(i);
            }
        }

        //start bfs
        while(!q.isEmpty()){
            int curr = q.poll();
            if(map.containsKey(curr)){
                List<Integer> edges = map.get(curr);
                for(int edge : edges){
                    indegrees[edge]--;
                    if(indegrees[edge] == 0){
                        q.add(edge);
                    }
                }
            }
        }

        for(int i = 0; i<indegrees.length; i++) {
            if(indegrees[i] > 0){
                return false;
            }
        }

        return true;
    }
}