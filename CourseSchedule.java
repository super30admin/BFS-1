public class CourseSchedule {
    // TC is O(V+E)
    // SC is 0(V+E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0)
            return true;
        int m = prerequisites.length;
        int n = prerequisites[0].length;
        int[] depedencyArray = new int[numCourses];
        Arrays.fill(depedencyArray, 0);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            depedencyArray[prerequisites[i][0]]++;
            if (!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < depedencyArray.length; i++) {
            if (depedencyArray[i] == 0) {
                q.add(i);
                count++;
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            List<Integer> list = new ArrayList<>();
            list = map.get(node);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    depedencyArray[list.get(i)]--;
                    if (depedencyArray[list.get(i)] == 0) {
                        q.add(list.get(i));
                        count++;
                        if (count == numCourses)
                            return true;
                    }
                }
            }

        }
        return false;
    }
}
