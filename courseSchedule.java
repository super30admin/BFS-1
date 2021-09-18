public class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Maintain the visited array
        int [] visited = new int[numCourses];
        ArrayList<Integer>[] nodes = new ArrayList[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            nodes[i] = new ArrayList<>();         
        }
        for(int i = 0; i < prerequisites.length; i++) {
            nodes[prerequisites[i][1]].add(prerequisites[i][0]);
        }
    
    
        for(int i = 0; i < numCourses; i++) {
            if(detectCycle(nodes, visited, i))
                return false;
        }
        
        return true;
    }
    
    private boolean detectCycle(ArrayList<Integer>[] nodes, int[] visited, int idx) {
        /*
            1 = processing
            2 = visited        
        */
        
        if(visited[idx] == 1) return true;
        if(visited[idx] == 2) return false;
        
        visited[idx] = 1;
        for(int node: nodes[idx]) {
            if(detectCycle(nodes, visited, node))
                return true;
        }
        
        visited[idx] = 2;
        return false;
        
    }   
}
