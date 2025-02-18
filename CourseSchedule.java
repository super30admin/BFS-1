// Time Complexity:  O(v+e)
// Space Complexity: O(v+e)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach: 
 * This problem is about determining if it's possible to complete all courses given the prerequisite dependencies. 
 * I have used an array indegree to track how many prerequisites each course has, and a HashMap `map` to store the courses dependent on others. 
 * Using a queue, I perform a topological sort to process courses with no prerequisites, decrementing the indegree of their
 * dependent courses and adding them to the queue, and if we can process all courses, we return true, otherwise false.
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         // If no courses are required, we can always finish
        if(numCourses == 0) {
            return true;
        }
        // Array to store the number of prerequisites each course has
        int[] indegree = new int[numCourses];

        // HashMap to store course dependencies, where key is a course and value is a list of courses that depend on it
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Building the dependency graph and calculating the indegree for each course
        for(int i = 0; i < prerequisites.length; i++) {
            int dependent = prerequisites[i][0]; // Course that depends on another
            int independent = prerequisites[i][1]; // Course that must be taken first
            indegree[dependent]++; // Increment the indegree of the dependent course
            if(!map.containsKey(independent)) {
                // If the independent course doesn't have a list of dependent courses, create it
                List<Integer> li = new ArrayList<>();
                
                map.put(independent, li);
            }
            // Add the dependent course to the list of courses that depend on the independent course
            map.get(independent).add(dependent);
        }
        // Count of courses that can be taken
        int count = 0;
         // Queue to hold courses with no prerequisites means which courses have indegree 0
        Queue<Integer> queue = new LinkedList<>();
        // Add all courses with no prerequisites to the queue
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
                count++; // Increment count as this course can be taken
            }
        }
        // If all courses can be taken from the start, return true
        if(count == numCourses) {
            return true;
        }
         // If no courses are available to take, return false (cycle detected)
        if(queue.isEmpty()) {
            return false;
        }
        // Process courses that have no prerequisites and check their dependents
        while(!queue.isEmpty()) {
            int curr = queue.poll();// Remove course from queue
            List<Integer> children = map.get(curr); // Get the list of dependent courses
            if(children == null) {
                continue;
            }
            // For each dependent course, decrease its indegree 
            for(Integer child: children) {
                indegree[child]--;
                 // If a dependent course now has no prerequisites left, add it to the queue
                if(indegree[child] == 0) {
                    queue.add(child);
                    count++;// Increment the count of courses we can take
                    // If we've taken all courses, return true
                    if(count == numCourses) {
                        return true;
                    }
                }
            }
        }
        // If we couldn't take all courses, it means there is a cycle and we return false
        return false;
    }
}
