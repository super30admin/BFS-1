class Solution {
    // Approach: BFS with HashMap, Array and Queue.
    // TC: O(V + E), SC: O(V + E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Populate dependenciesMap and numOfPrerequisites[]
        Map<Integer, List<Integer>> dependenciesMap = new HashMap<>();
        int[] numOfPrerequisites = new int[numCourses];
        for (int[] prerequisite: prerequisites) {
            int dependentCourse = prerequisite[0];
            int course = prerequisite[1];
            dependenciesMap.putIfAbsent(course, new ArrayList<>());
            dependenciesMap.get(course).add(dependentCourse);
            numOfPrerequisites[dependentCourse] ++;
        }
        // Populate independentCourses queue and count.
        Queue<Integer> independentCourses = new LinkedList<>();
        int completedCourses = 0;
        for (int i = 0; i < numCourses; i ++) {
            if (numOfPrerequisites[i] == 0) {
                independentCourses.offer(i);
                completedCourses ++;
            }
        }
        // No course can be completed.
        if (independentCourses.isEmpty()) {
            return false;
        }
        // All courses can be completed.
        if (completedCourses == numCourses) {
            return true;
        }
        // Complete other courses using independentCourses queue.
        while (!independentCourses.isEmpty()) {
            int course = independentCourses.poll();
            if (dependenciesMap.containsKey(course)) {
                List<Integer> dependentCourses = dependenciesMap.get(course);
                for (int dependentCourse: dependentCourses) {
                    numOfPrerequisites[dependentCourse] --;
                    if (numOfPrerequisites[dependentCourse] == 0) {
                        // No prerequisites left. Course can be completed.
                        independentCourses.offer(dependentCourse);
                        completedCourses ++;
                        // Check if all courses are completed.
                        if (completedCourses == numCourses) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}