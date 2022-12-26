// COURSE SCHEDULE

// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for(int[] edge: prerequisites){
            indegrees[edge[0]]++; // Increase the dependency of the dependent node
            //Independent to Dependent
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()) return false;
        if(count == numCourses) return true;
        while(!q.isEmpty()){
            int curr = q.poll();
            // reduce the indegrees of the children
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child: children){
                indegrees[child]--;
                if(indegrees[child] == 0){
                        q.add(child);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }
        return false;
    }
}