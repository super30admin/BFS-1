// Problem1 - https://leetcode.com/problems/course-schedule/

// Time Complexity : O(V + E)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

class BFS {
    public boolean canFinish(int numCourses, int[][] edges) {
        if(edges.length == 0) return true;
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int [] edge: edges){
            indegree[edge[0]] ++;
            
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        //BFS
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0; i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
                count++;
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child: children){
                    indegree[child]--;
                    if(indegree[child] == 0){
                        q.add(child);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }
    
        return false;
    }
}