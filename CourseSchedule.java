/**
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * LeetCode: Y (https://leetcode.com/problems/course-schedule/)
 * Approach: 
 *  Insight: Visualize the problem as a directed graph.
 *  The first course that can be taken needs to have an in-degree equal to 0 i.e. no prerequisites for that course
 *  So start traversing the graph from a vertex where in-degree is 0 and 
 *  the graph can be traversed and the graph does not have a cycle
 *  then it is possible to finish all the courses
 *
 *
 * Maintian a variable to count the courses taken
 * Convert edge list to adjacency list
 * Maintain a running indegree array
 * Initialize a Queue to process the courses in order they must be taken
 * Calculate initial in-degree array
 * Enqueue all courses with 0 prerequisites 
 * Loop until the queue is empty
 *    Poll from the queue i.e. A COURSE WAS TAKEN so increment coursesTaken
 *    decrement the in-degree of adjacent courses
 *    if the in-degree of adjacent course reduces to 0 then enqueue it
 * If the courses taken equals given number of courses then return true else return false
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // check edge case
        if(prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        
        // to maintian a running inDegree of all the courses
        int[] inDegree = new int[numCourses];
        
        // to maintain which course can be taken next
        Queue<Integer> q = new LinkedList<Integer>();
        
        // to track the number of courses taken
        int coursesTaken = 0;
        
        // to convert edge list into adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        // allocate memory for adjacency list
        for(int i = 0 ; i < numCourses ; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        
        // poulate inDegree array and adjacencyList
        for(int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        // Enqueue all the courses whose inDegree is 0
        for(int i = 0 ; i < inDegree.length ; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }
        
        // Loop until queue is empty
        while(!q.isEmpty()) {
            // get the first current course from the queue
            int currentCourse = q.poll();
            
            // increment the courses taken
            coursesTaken++;
            
            // Loop over the adjacent courses of current course
            for(int adjacentCourse : adjacencyList.get(currentCourse)) {
                // reduce in-degree of adjacent course
                inDegree[adjacentCourse]--;
                
                // if the in-degree of adjacent course reduces to 0 then enqueue the adjacent course
                if(inDegree[adjacentCourse] == 0) {
                    q.add(adjacentCourse);
                }
            }
        }
        
        // if all courses taken equals given number of courses then return true else return false
        return (coursesTaken == numCourses);  
    }
}
