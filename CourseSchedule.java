public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegress = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : prerequisites) {
            indegress[edge[0]]++;
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < indegress.length; i++) {
            if (indegress[i] == 0) {
                q.add(i);
                count++;
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> li = map.get(curr);
            if (li != null) {
                for (int child : li) {
                    indegress[child]--;
                    if (indegress[child] == 0) {
                        q.add(child);
                        count++;
                    }
                }
            }
        }

        return count == numCourses;

    }
}