import java.util.*;

class CourseSchedule1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true;
        }

        //Create an In-degrees array to store how many pre-req needed for each course
        //This will help us to know whether all courses can be taken if all the pre-rep
        //has been completed mean become all zero's
        int[] indegrees = new int[numCourses];

        for(int[] course : prerequisites){
            int index = course[0];
            indegrees[index] += 1;
            //System.out.println("indegrees:"+index+":"+indegrees[index]);
        }
        
        //Create a adjucency list to hold which PreReq : Courses
        //This will help us to know which courses are depend on which prereq
        //In other words, when prereq is completed which dependant courses can be started.
        Map<Integer, List<Integer>> adjucencyList = new HashMap<>();

        for(int[] prereq : prerequisites){
            int prereqKey = prereq[1];
            if(!adjucencyList.containsKey(prereqKey)){
                List courseList = new ArrayList<Integer>();
                adjucencyList.put(prereqKey, courseList);
            }
            adjucencyList.get(prereqKey).add(prereq[0]);
        }
        //System.out.println("****adjucencyList");
        //System.out.println(adjucencyList);

        //Now run BFS to traverse the graph 
        //Keep adding course to queue which has completed all the prereq = 0 in Indegree array
        //Once all the indegrees elements are 0 means all prereq has been completed return true else false
        Queue<Integer> queue = new LinkedList<>();

        //To start, Find out course which doesn't require prereq
        
        for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] == 0){
                queue.add(i);
            }    
        }

        while(!queue.isEmpty()){
            int currentCourse = queue.poll();
            indegrees[currentCourse] = indegrees[currentCourse] != 0 ? indegrees[currentCourse]-1 : 0;

            if(indegrees[currentCourse] == 0){
                List courseList = adjucencyList.get(currentCourse);
                    if(courseList != null){
                        for(int i = 0; i < courseList.size(); i++){
                        int courseValue = (Integer)courseList.get(i);
                        queue.add(courseValue);
                    }
                }
            }
        }
        
       for(int i = 0; i < indegrees.length; i++){
            if(indegrees[i] != 0){
                return false;
            }    
        }

        return true;
    }
}

//Time Complexity: O(V+E) // (Vertises + Edges)
//Space Complexity: O(V+E) // (Vertises + Edges)