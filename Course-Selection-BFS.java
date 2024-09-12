class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
            
             if (!map.containsKey(prerequisites[i][1])){
                 map.put(prerequisites[i][1], new ArrayList<>());
             }
            
             map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0)q.add(i);
        }
        
        while(!q.isEmpty()){
            int course = q.poll();
            List<Integer> children = map.get(course);
            
            if (children != null){
                for (Integer child : children){
                    indegree[child]--;
                    
                    if (indegree[child] == 0)q.add(child);
                }
            }
            
        }
        
        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] != 0) return false;
        }
        return true;
    }
}