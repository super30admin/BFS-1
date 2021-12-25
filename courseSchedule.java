
/* 
Time Complexity : O(V+E) where V is the number of Vertices and E is the number of Edges
 Space Complexity : O(V+E) 
 Did this code successfully run on Leetcode : Yes 
 Any problem you faced while coding this : No
 Uisng BFS approach 
 First we need to findthe degree of each subjects and also create a map dependents of particular subject
 then Do BFS 
 */


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true;
        }
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] indegree = new int[numCourses];
        for(int []edge : prerequisites){
            indegree[edge[0]]++;
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);       
        }
        for(int i = 0 ; i< indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            List<Integer> deps = map.get(curr);
            if(deps != null){
            for(int edge : deps){
                indegree[edge]--;
                if(indegree[edge] == 0){
                    q.add(edge);
                }
            }
        }
        }
        if(count == numCourses){
            return true;
        }
        else{
            return false;
        }      
    }
}
