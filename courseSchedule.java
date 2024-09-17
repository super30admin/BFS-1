(/**
Problem: https://leetcode.com/problems/course-schedule/)
*/

/**
Approach 1: BFS
TC: O(max(numCourses, prerequisites.length)) => O(max(V,E)) => O(V + E)
SC: O(max(numCourses, prerequisites.length)) => O(max(V,E)) => O(V + E)
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

/**
Approach 2: DFS - we need to maintain a path array to help detect cycles and a visited array 
to not process the same node multiple times
TC: O(V+E)
SC: O(V+E)
*/
class Solution {
    int coursesTaken = 0;
    boolean path[] = null;
    boolean visited[] = null;
    List<List<Integer>> adjacencyList = null;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        
        adjacencyList = new ArrayList<>();
        coursesTaken = 0;
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; ++i) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < prerequisites.length; ++i) {
            adjacencyList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        for (int i = 0; i < numCourses; ++i) {
            if (!visited[i] && hasCycle(i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCycle(int course) {
        if (path[course]) return true;
        if (visited[course]) return false;
        
        path[course] = true;
        visited[course] = true;
        
        for (int nextCourse : adjacencyList.get(course)) {
            if (hasCycle(nextCourse)) {
                return true;
            }
        }
        path[course] = false;
        return false;
    }
}