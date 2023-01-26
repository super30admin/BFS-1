// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach
// start taking the courses one by one, queue processing all the courses
// courses which have indegrees will be added to queue and decrease the indegree count
// if q is empty, no independent courses are there.

// BFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++){
            indegrees[prerequisites[i][1]]++;    //[a,b], b is the independent node, so edge[1]
            //independent to dependent
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0], new ArrayList<>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }


        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            //reduce the indegrees of babies
            List<Integer> children = map.get(curr);
            if(children != null){
                for(Integer child : children){
                    indegrees[child]--;
                    if(indegrees[child] == 0){
                        q.add(child);
                    }
                }
            }
        }

        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] != 0) return false;
        }
        return true;

    }
}