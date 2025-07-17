// Time Complexity :  O(V + E) where V is the number of courses and E is the number of prerequisites
// Space Complexity : O(V + E) for the adjacency list and course dependencies array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I made a graph using an adjacency list where each course points to the courses that depend on it.
// I also maintained an array to keep track of the number of prerequisites for each course.
// I then used a queue to perform a BFS traversal. I started with courses that had no prerequisites and added them to the queue.
// For each course processed, I reduced the prerequisite count of its dependent courses.
// If any dependent course's prerequisite count reached zero, it was added to the queue.
// Finally, I checked if the number of completed courses matched the total number of courses.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courseDependencies = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();
        for(int [] courses : prerequisites){
            int course = courses[0];
            int prereq = courses[1];
            if(!adjacencyList.containsKey(prereq)) adjacencyList.put(prereq, new ArrayList<>());
            adjacencyList.get(prereq).add(course); 
            courseDependencies[course]++;
        }
        Queue<Integer> canDoCourses = new LinkedList<>();
        int completedCourses = 0;
        for(int i = 0; i<numCourses; i++){
            if(courseDependencies[i]==0) {
                canDoCourses.add(i);
                completedCourses++;
            }
        }
        while(!canDoCourses.isEmpty()){
            int courseId = canDoCourses.poll();
            ArrayList<Integer> futureCourses = adjacencyList.get(courseId);
            if(futureCourses==null) continue;
            for(int course : futureCourses){
                courseDependencies[course]--;
                if(courseDependencies[course]==0){
                    canDoCourses.add(course);
                    completedCourses++;
                } 
            }
        }
        return completedCourses == numCourses;
    }
}