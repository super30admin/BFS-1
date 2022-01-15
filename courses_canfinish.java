// Time Complexity : O(V+E) - adjancency list traversal
// Space Complexity : O(V+E) -  adjancency list storage

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Create adjacency matrix 
        
        // given only vertices and edges 
        // Vertices are : V : 0 to numCourses
        // Edges are prerequisites
    
        int[] dependency =  new int[numCourses];
        
        // For a particular node , count the number of times it is dependent for a course.
        for (int i = 0; i < prerequisites.length; i ++){
            dependency[prerequisites[i][0]]++; // dependent is in 0th index
        }
        
       // Adjancency list
        List <List<Integer>> adjacencyList = new ArrayList<>();
        
        // empty list for each course
        for (int i=0; i < numCourses; i++ ){
            adjacencyList.add(new ArrayList<>());    
        }
        
        // For a node, map the list of all the dependent courses 
         for (int i=0; i < prerequisites.length; i++ ){
             // Get the independent node and add the dependent node correspondingly
            adjacencyList.get(prerequisites[i][1]).add(prerequisites[i][0]);    
        }
        
        // Queue
        Queue <Integer> q = new LinkedList<>();
        
        // Take the independent nodes : Zero value in the dependency list
        for (int i = 0; i < numCourses; i ++){
            if (dependency[i] == 0){
                q.add(i); // add the independent node into queue
            } 
        }
        
        // Process each independent node by polling it and reducing the corresponding dependent node value in the dependency list by 1 and push the new nodes as per the updated dependency list.
        
        while (!q.isEmpty()){
            
            int currCourse = q.poll();
            
            // their dependent courses, reduce the value by 1
            List<Integer> dependentCourses =  adjacencyList.get(currCourse);
            
            for (int i= 0; i< dependentCourses.size(); i++){
                
                //the current course node is considered, so the nodes that this currCourse is dependent to must be reduced.
                dependency[dependentCourses.get(i)]--;
            
                // If dependent becomes independent node : then add it into the queue
                if (dependency[dependentCourses.get(i)] == 0){
                    q.add(dependentCourses.get(i)); // eligible as independent
                }
            }
        }
                    
        // If the courses are not 0 : that means they are not taken
        for (int i = 0; i < numCourses; i ++){
            if (dependency[i] != 0){
               return false;
            } 
        }
        
        return true;
    }
}