// TC - O(V + E)
// SC - O(V + E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        for(int[] edge:prerequisites){
            int in = edge[0];
            int out = edge[1];
            
            indegree[in]++;
            
            if(!map.containsKey(out))
                map.put(out,new ArrayList<>());
            map.get(out).add(in);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int CoursesCompleted = 0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                CoursesCompleted++;
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> currList = map.get(curr);
            if(currList!=null){
                for(int edge : currList){
                    indegree[edge]--;
                    if(indegree[edge] == 0){
                        CoursesCompleted++;
                        q.add(edge);
                    }
                }
            }
        }
        return CoursesCompleted == numCourses;
    }
}