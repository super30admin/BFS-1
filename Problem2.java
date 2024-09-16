
// Problem 2
// Course Schedule (https://leetcode.com/problems/course-schedule/)
// Time complexity O(V + E) 
    // Space complexity O(V + E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Create a map to store dependency mapping
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        // Step 2: Store an array to know the count the prerequisite of each course 
        
        int[] courses = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
            courses[prerequisites[i][0]]++;
          
            if(!map.containsKey(prerequisites[i][1])) {
               map.put(prerequisites[i][1], new ArrayList<>());
            }
           
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
             
            
        }
        
        //Step 3: Create a queue to maintain the order of processing the courses from the least dependent to most
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < courses.length; i++){
            if(courses[i] == 0){
                q.add(i);
            }
        }
        
        if(q.isEmpty()) return false;
        
       
        int courseCount = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            
            courseCount++;
            List<Integer> children = map.get(curr);
            
            if(children != null){
                for(int child: children){
                    
                    courses[child]--;
                    if(courses[child] == 0){
                        q.add(child);
                    }
                }
            }
        }
        
        
        
        return courseCount == numCourses;
    }
}