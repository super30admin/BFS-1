class CourseSchedule {
    
    // Time Complexity: O(v + e)    (where v -> no. of vertices and e -> no. of edges)    
    // Space Complexity: O(v)
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an indegree array -> to count the number of prerequisites for each course
        int[] inDegree = new int[numCourses];
        int numCoursesCompleted = 0;
        
        // If course 0 has pre-requisite 1, then the graph would be 1->0
        // here we don't care about what that pre-requisite is we just want the count that for a particular course how many pre-requisites we have.
        for(int i = 0; i < prerequisites.length; i++){
            inDegree[prerequisites[i][0]]++;
        }
        
        // Create a stack and add those courses in the stack which have no prerequisities
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0)
                stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int curr = stack.pop();
            numCoursesCompleted++;      // Increment the course completed count
            // If the courses which was just completed was a prerequisite for another course -> then reduce the prerequisite count for that course
            // If the prerequisite count for a course becomes zero -> then add it to the stack
            for(int i = 0; i < prerequisites.length; i++){
                if(prerequisites[i][1] == curr){
                    inDegree[prerequisites[i][0]]--;
                    if(inDegree[prerequisites[i][0]] == 0)
                        stack.push(prerequisites[i][0]);
                }
            }
        }
        
        // If all the courses can be completed then true else false (there's a deadlock if the count doesn't match)
        return numCoursesCompleted == numCourses;
    }
}