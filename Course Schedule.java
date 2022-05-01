// Time Complexity : O(V+E) where v is the number of courses and r is the  size of prerequisites.
// Space Complexity : O(V+E) where v is the number of courses and r is the  size of prerequisites.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null||prerequisites.length==0)
            return true;
        int [] indegrees = new int[numCourses];
        int count = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            indegrees[prerequisites[i][0]]++;
            map.putIfAbsent(prerequisites[i][1],new ArrayList<>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<indegrees.length;i++){
            if(indegrees[i]==0){
                count++;
                q.add(i);
            }
        }
        if(q.isEmpty())
            return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if(edges!=null){
             for(int i: edges){
                indegrees[i]--;
                if(indegrees[i]==0){
                    count++;
                    q.add(i);
                    }
                }
            }  
        }
        return count==numCourses;
    }
}
