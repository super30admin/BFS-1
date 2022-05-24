// Time Complexity :O(v+e) -v=vertices, e=edges
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        int count = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            indegrees[prerequisites[i][1]]++;
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0], new ArrayList<>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int course = q.poll();
            List<Integer> children = map.get(course);
            if(children!=null){
                for(int i:children){
                    indegrees[i]--;
                    if(indegrees[i]==0){
                        q.add(i);
                    }
                }
            }
        }
        
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]!=0){
                return false;
            }
        }
        return true;
    }
}
