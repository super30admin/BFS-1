// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Take a course which has no prerequisite first
//Check which all courses are dependent and remove all the dependencies
//repeat the procedure

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses ==0) {
            return true;
        }
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=0;i<prerequisites.length;i++) {
            indegrees[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])) {
               map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        //every time indegree turns 0 oush it in the queue
        for(int i=0;i<numCourses;i++) {
            if(indegrees[i] == 0) {
                q.add(i);
            }                           
        }

        while(!q.isEmpty()) {
            int ele = q.poll();
            List<Integer> children = map.get(ele);
            if(children != null) {
                for(int num : children ) {
                    indegrees[num]--;
                    if(indegrees[num] == 0) {
                        q.add(num);
                    }
                }
            }

        }
        for(int i=0;i<numCourses;i++) {
            if(indegrees[i] > 0) {
                return false;
            }
        }
        return true;
    }
}