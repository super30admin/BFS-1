
public class CourseSceduler {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> indmap = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] prereq : prerequisites) {
            int in = prereq[0];
            int out = prereq[1];
            indegree[in]++;
            if (!indmap.containsKey(out)) {
                indmap.put(out, new ArrayList<>());
            }
            indmap.get(out).add(in);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                count++;
            }
        }

        if (count == numCourses)
            return true;
        if (count == 0)
            return false;

        while (!q.isEmpty()) {
            int parent = q.poll();
            List<Integer> children = indmap.get(parent);
            if (children != null) {
                for (Integer child : children) {
                    indegree[child]--;
                    if (indegree[child] == 0) {
                        q.add(child);
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
