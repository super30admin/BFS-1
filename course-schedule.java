// Time Complexity : O(V + E)
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int []indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        for(int []edge : prerequisites){   
            indegrees[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegrees.length; i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child : children){
                    indegrees[child]--;
                    if(indegrees[child]==0){
                        q.add(child);
                    }
                }
            }
        }
        for(int i=0; i<indegrees.length; i++){
            if(indegrees[i]>0){
                return false;
            }
        }
        return true;
    }
}