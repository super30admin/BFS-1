// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // null

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for(int[] edge: prerequisites){
            indegrees[edge[0]]++; //dependent node
            if(!map.containsKey(edge[1])){ //indep node
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0; //how many courses have I taken (indep)
        for(int i=0; i<indegrees.length; i++){
            if(indegrees[i] == 0){
                q.add(i); //add this indep course
                count++;
            }
        }
        if(q.isEmpty()) return false; //cycle detected, no indep
        while(!q.isEmpty()){
            int curr = q.poll();
            // dependencies of this course
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child: children){
                    indegrees[child]--;
                    if(indegrees[child] == 0){
                        q.add(child); count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}