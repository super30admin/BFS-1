class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> hp = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            hp.put(i, new LinkedList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] tp : prerequisites) {
            int course = tp[0];
            int prerequisite = tp[1];

            hp.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int currentCourse = q.poll();
            List<Integer> current = hp.get(currentCourse);

            for (int course : current) {
                indegree[course]--;
                if (indegree[course] == 0) {
                    q.add(course);
                }
            }
            count++;
        }
        if (count == numCourses) {
            return true;
        }

        return false;
    }
}