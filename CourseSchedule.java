class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //check for 0
        if(numCourses==0 || prerequisites.length==0) return true;
        //make indegree array
        int[] indegrees = new int[numCourses];
        //fill indegree array
        for(int i=0;i<prerequisites.length;i++){
            indegrees[prerequisites[i][0]]++;
        }
        // declare queue for bfs
        Queue<Integer> q = new LinkedList<Integer>();
        // check for 0 indegree in indegrees array
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                q.add(i);
            }
        }
        int canTakeCourse = q.size();
        // while not q empty take element out of queue check for whom it is pre req reduce indegree of that and if that becomes 0 add to q and increase count
        while(!q.isEmpty()){
            int course = q.remove();
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1]==course){
                    indegrees[prerequisites[i][0]]--;
                     if(indegrees[prerequisites[i][0]]==0){
                    canTakeCourse++;
                    q.add(prerequisites[i][0]);
                }
                }
                
            }
            
            
        }
        //if at end these two equal we can compelte
        
       return numCourses == canTakeCourse; 
    }
}