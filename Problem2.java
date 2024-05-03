package BFS-1;

public class Problem2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int count = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] course : prerequisites) {
            indegree[course[0]]++;
            if (!map.containsKey(course[1])) {
                map.put(course[1], new ArrayList<>());
            }
            map.get(course[1]).add(course[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                count++;
            }
        }
        if (count == numCourses)
            return true;
        while (!q.isEmpty()) {
            Integer currCourse = q.poll();
            List<Integer> depCourses = map.get(currCourse);
            if (depCourses != null) {
                for (Integer course : depCourses) {
                    indegree[course]--;
                    if (indegree[course] == 0) {
                        q.add(course);
                        count++;
                    }
                    if (count == numCourses)
                        return true;
                }
            }

        }
        return false;
    }
}
