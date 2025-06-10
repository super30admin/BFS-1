// Time Complexity : O(Edges + verticies), 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for(int[] edges : prerequisites){
            int in = edges[0];
            int out  = edges[1];
            indegrees[in]++;
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child : children){
                    indegrees[child]--;
                    if(indegrees[child] == 0){
                        q.add(child);
                        count++;
                        if(count == numCourses){
                            return true;
                        }
                    }
                }
            }
        }
        if(count == numCourses){
            return true;
        }
        return false;
    }
}
