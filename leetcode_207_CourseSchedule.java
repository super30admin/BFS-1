// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        int indegree[] = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        int n = prerequisites.length;
        //iterate over the prerequisities array, have to complete the indgrees and the map
        for(int i = 0; i < n; i++){
            int ind = prerequisites[i][1];
            int dep = prerequisites[i][0];
            indegree[dep]++;
            if(!map.containsKey(ind)){
                map.put(ind, new ArrayList<>());
            }
            map.get(ind).add(dep);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
                count++;
            }
        }
        if(count == numCourses) return true;
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int current = q.poll();
            //children of current
            List<Integer> children = map.get(current);
            if(children == null) continue;
            for(Integer child: children){
                indegree[child]--;
               if(indegree[child] == 0){
                q.add(child);
                count++;
                if(count == numCourses) return true;
               } 
            }
        }
        return false;
    }
}