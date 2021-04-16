// Time Complexity : O(V+E)
// Space Complexity : O(V+E) Num of courses + num of dependencies
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int[] edge : prerequisites){
            inDegree[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1],new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int currCourse = q.poll();
            cnt++;
            List<Integer> nextCourses = map.get(currCourse);
            if(nextCourses != null){
                for(int nextCourse: nextCourses){
                    inDegree[nextCourse]--;
                    if(inDegree[nextCourse] == 0) q.add(nextCourse);
                }
            }
        }
        return cnt == numCourses;
        
    }
}
