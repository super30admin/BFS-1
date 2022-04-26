/**
Problem: https://leetcode.com/problems/course-schedule/
TC: O(max(numCourses, prerequisites.length))
SC: O(max(numCourses, prerequisites.length))
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        
        List<List<Integer>> adjacencyList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int indegree[] = new int[numCourses];
        
        for (int i = 0; i < numCourses; ++i) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < prerequisites.length; ++i) {
            adjacencyList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            ++indegree[prerequisites[i][0]];
        }
        
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        
        if (queue.isEmpty()) {
            return false;
        }
        
        int coursesTaken = 0;
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            ++coursesTaken;
            List<Integer> dependentCourses = adjacencyList.get(curCourse);
            
            for (int dependentCourse : dependentCourses) {
                --indegree[dependentCourse];
                if (indegree[dependentCourse] == 0) {
                    queue.add(dependentCourse);
                }
            }
        }
        
        return coursesTaken == numCourses;
    }
}