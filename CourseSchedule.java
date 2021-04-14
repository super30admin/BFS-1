// Time Complexity :O(V+E)
// Space Complexity :O(V)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return true;
        int[] courseNeeded = new int[numCourses];
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        // Find the number of dependency for each course
        for (int[] course : prerequisites) {
            courseNeeded[course[0]]++;
            // update in hash the course that are dependant on each course
            if (!hmap.containsKey(course[1])) {
                hmap.put(course[1], new ArrayList<>());
            }
            hmap.get(course[1]).add(course[0]);
        }
        // Add the course with 0 dependency in queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (courseNeeded[i] == 0)
                queue.add(i);
        }

        // to keep track of courses completed keep a count
        int count = 0;
        while (!queue.isEmpty()) {
            // -remove/complete the course
            int j = queue.poll();
            count++;
            List<Integer> temp = hmap.get(j);
            if (temp != null) {
                for (int i : temp) {
                    courseNeeded[i]--;
                    if (courseNeeded[i] == 0)
                        queue.add(i);
                }
            }
        }
        return count == numCourses;
    }
}