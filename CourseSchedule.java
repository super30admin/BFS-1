public class CourseSchedule {
        public boolean canFinish(int numCourses, int[][] prereq) {
            if (prereq == null || prereq.length == 0) return true;
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            int[] inDegrees = new int[numCourses];
            for (int[] edge : prereq) {
                inDegrees[edge[0]]++;
                if (!map.containsKey(edge[1])) {
                    map.put(edge[1], new ArrayList<>());
                }
                map.get(edge[1]).add(edge[0]);
            }

            Queue<Integer> q = new LinkedList<>();
            int count = 0;

            for (int i = 0; i < numCourses; i++) {
                if (inDegrees[i] == 0) {
                    q.add(i);
                    count++;
                }
            }
            if (q.isEmpty()) return false;

            while (!q.isEmpty()) {
                int curr = q.poll();
                List<Integer> edges = map.get(curr);
                if (edges != null) {
                    for (int edge : edges) {
                        inDegrees[edge]--;
                        if (inDegrees[edge] == 0) {
                            q.add(edge);
                            count++;
                        }
                    }
                }
            }
            return count == numCourses;
        }
}
