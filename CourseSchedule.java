class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        int count = 0;
        
        for(int  i = 0; i < prerequisites.length; i++){
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            
            if(matrix[pre][ready] == 0)
                inDegree[ready]++;
            matrix[pre][ready] = 1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }    
        }
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for(int i = 0; i < numCourses; i++){
                if(matrix[course][i] != 0){
                    inDegree[i] = inDegree[i] - 1;
                    if(inDegree[i] == 0){
                        queue.add(i);
                    }
                }
            }
        }   
        return count == numCourses;
    }
}

Time Complexity: O(|E| + |V|) where V - number of verteces and E - number of edges
Space Complexity: O(V) where E is maximum number of Verteces in queue