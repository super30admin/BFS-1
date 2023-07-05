import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int[] inDegrees = new int[numCourses];

        for (int[] pr : prerequisites) {
            inDegrees[pr[0]]++;

            if (!map.containsKey(pr[1])) {
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]);
        }

        // System.out.println (Arrays.toString(inDegrees));
        // System.out.println(map);

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            ArrayList<Integer> children = map.get(curr);
            if (children != null) {
                for (int child : children) {
                    inDegrees[child]--;
                    if (inDegrees[child] == 0) {
                        q.add(child);
                        count++;

                        if (count == numCourses) {
                            return true;
                        }
                    }
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 1 }, { 3, 2 } };

        boolean canFinish = courseSchedule.canFinish(numCourses, prerequisites);

        System.out.println("Can finish all courses: " + canFinish);
    }
}
