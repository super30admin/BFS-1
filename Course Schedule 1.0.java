// Time Complexity = O(V+E)
// Space Complexity = O(V+E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;
        if (prerequisites.length == 0) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] indegrees = new int [numCourses];
        for(int [] edge:prerequisites){
            int dependent = edge[0];
            int indep     = edge[1];
            indegrees[dependent]++;
            if(!map.containsKey(indep)){
                map.put(indep, new ArrayList<>());
            }
            
            map.get(indep).add(dependent);
        }
            Queue<Integer> q = new LinkedList<>();
            
            int count = 0;
            for (int i = 0; i<numCourses; i++){
                if(indegrees[i] == 0){
                    q.add(i);
                    count++;
                }
            }   
            
            if(q.isEmpty()) return false;
            
            while(!q.isEmpty()){
                int curr = q.poll();
                List<Integer> children = map.get(curr);
                if(children != null){
                   for (int child : children){
                    indegrees[child]--;
                    if(indegrees[child] == 0){
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