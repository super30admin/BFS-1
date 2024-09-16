// Time Complexity : O(N) - As we iterate through all the nested lsit given
// Space Complexity : O(N) -  As we use three data structures a HashMap,Queue and a Integer Array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         int[] indegree = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < prerequisites.length;i++){
            indegree[prerequisites[i][1]]++;
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0],new ArrayList<Integer>());
            }
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for(int i = 0;i < numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int course = queue.poll();
            List<Integer> childnodes = map.get(course);
            if(childnodes != null){
                for(int c : childnodes){
                    indegree[c]--;
                    if(indegree[c] == 0){
                        queue.add(c);
                    }
                }
            }
        }
        for(int i = 0;i < numCourses;i++){
            if(indegree[i] != 0) return false;
        }
        return true;
    }
}
// Your code here along with comments explaining your approach