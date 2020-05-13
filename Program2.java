//Time Complexity : O(n)
//Space Complexity : O(n)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegrees =new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<prerequisites.length;i++){
            indegrees[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);  
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegrees.length;i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            List<Integer> dependents = map.get(node);
            if(dependents!=null){
                 for(Integer d : dependents){
                indegrees[d]--;
                if(indegrees[d]==0){
                    q.add(d);
                }
            }
            }
           
            
        }
        
        for(int i=0 ;i<indegrees.length;i++){
            if(indegrees[i]>0){
                return false;
            }
        }
        
        return true;
        
    }
}