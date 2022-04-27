// Time Complexity : O(V + E)
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(prerequisites == null || prerequisites.length == 0) return true;
        
        int[] inDegrees = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int count = 0;
        
        for(int[] edge: prerequisites) {
            inDegrees[edge[0]]++;
            
            if(!adjList.containsKey(edge[1])) {
                adjList.put(edge[1], new ArrayList<>());
            }
            
            adjList.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < inDegrees.length; i++) {
            if(inDegrees[i] == 0) {
                queue.add(i);
                count++;
            }
        }
                
        while(!queue.isEmpty()) {
            int course = queue.poll();
            
            List<Integer> dependencies = adjList.get(course);
            
            if(dependencies != null) {
               for(int dependency: dependencies) {
                inDegrees[dependency]--;
                
                if(inDegrees[dependency] == 0) {
                    queue.add(dependency);
                    count++;
                }
            } 
            }
            
        }
        return count == inDegrees.length;
    }
}