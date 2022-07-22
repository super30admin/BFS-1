// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true;
        }
        int inDegress[] = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int[] req:prerequisites){
            int in = req[0];
            int out = req[1];
            inDegress[in]++;
            if(!map.containsKey(out)){
                map.put(out,new ArrayList<>());
            }
            map.get(out).add(in);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegress[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            List<Integer> edges = map.get(cur);
            if(edges == null){
                continue;
            }
            for(int edge:edges){
                inDegress[edge]--;
                if(inDegress[edge] == 0){
                    q.add(edge);
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(inDegress[i]!=0){
                return false;
            }
        }
        return true;
    }
}