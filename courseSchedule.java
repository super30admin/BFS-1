import java.util.*;

class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;
        
        //graph: map to store all prereqs and the courses dependent on them
        Map<Integer, List<Integer>> courseMap = new HashMap<>();

        //dependency array to store the number of prereqs each course has
        int[] indegrees = new int[numCourses];
        
        //placing courses in map and array
        for(int[] prereq : prerequisites){
            int out = prereq[1];
            int in = prereq[0];
            
            if(!courseMap.containsKey(out)){
                courseMap.put(out, new ArrayList<>());
            }
            courseMap.get(out).add(in);
            indegrees[in]++;
        }
        
        //queue
        Queue<Integer> queue = new LinkedList<>();
        
        //independent courses added to the queue first
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }
        
        //if no courses are independent
        if(queue.size() == 0) return false;
        
        //all courses are independent so we are done
        if(queue.size() == numCourses) return true;
        
        int completed = 0;
        
        while(!queue.isEmpty()){
            int prereq = queue.poll();
            
            completed++;
            
            List<Integer> courses = courseMap.get(prereq);
            
            if(courses != null){
                for(int course : courses){
                    
                    //reduce prereq count
                    indegrees[course]--;
                    
                    //ready to take course
                    if(indegrees[course] == 0){
                        queue.add(course);
                    }
                }
            }
        }
        
        return completed == numCourses;
    }
}