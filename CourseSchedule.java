// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : In coming up with the logic to create a HashMap, indices array and queue 

// Notes : Create an array with the index denoting the number of times that course is a prerequisite, ie. not an independent course. Also, create a HashMap of a course and a list of courses whose prerequisite is this course. Then create a queue of all the independent courses, and while this queue is not empty keep adding dependent courses, by decreasing count of that course in the array whose prerequisite is this course(taken from the HashMap). If all the elements in array are 0, which means no dependent courses, return true.
  
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        
        int arr[] = new int[numCourses];
        HashMap<Integer, List<Integer>> edges = new HashMap<>();
        
        for(int i = 0; i < prerequisites.length; i++){

            arr[prerequisites[i][0]] = arr[prerequisites[i][0]] + 1;
            
            if(!edges.containsKey(prerequisites[i][1]) ){
                edges.put(prerequisites[i][1], new ArrayList<Integer>()); 
            } 
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);    
        }
        
        Queue<Integer> q = new LinkedList<>();
        int countOfCourses = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                q.add(i);
            }  
        }
        
        //check if no independent course exists
        if(q.isEmpty()) return false;
        
        while(!q.isEmpty()){
            int course = q.poll();
            countOfCourses = countOfCourses + 1;
            
            List<Integer> li = edges.get(course);

            if(li != null){
                for(int i = 0; i < li.size() ; i++){
                    arr[li.get(i)] = arr[li.get(i)] - 1;

                    if(arr[li.get(i)] == 0){
                        q.add(li.get(i));
                    }
                }
            }
        }
        
        if(countOfCourses != numCourses) return false;
        
        return true;
    }
}
