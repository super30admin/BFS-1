// Time Complexity : O(V+E) where V = number of vertices, E = number of edges (connections between vertices)
// Space Complexity : O(n) where n = number of courses
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//207. Course Schedule (Medium) - https://leetcode.com/problems/course-schedule/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        
        for (int[] prerequisite : prerequisites) {
            inDegrees[prerequisite[0]]++;
            
            // map independent to dependent courses
            if (!adjacencyList.containsKey(prerequisite[1])) {
                adjacencyList.put(prerequisite[1], new ArrayList<>());
            }
            
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        
        for (int course = 0; course < numCourses; course++) {
            // add independent courses in queue
            if (inDegrees[course] == 0) {
                queue.add(course);
                count++;
            }
        }
        
        if (queue.isEmpty()) return false;
        if (count == numCourses) return true;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> dependencyList = adjacencyList.get(curr);
            
            // reduce the corresponding dependencies by taking one course from queue
            if (dependencyList != null) {
                for (int course : dependencyList) {
                    inDegrees[course]--;

                    if (inDegrees[course] == 0) {
                        queue.add(course);
                        count++;

                        if (count == numCourses) return true;
                    }
                }
            }
        }
        
        return false;
    }
}