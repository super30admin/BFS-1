import java.util.*;

public class problem2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] pr: prerequisites) {
            indegree[pr[0]]++;

            if (!map.containsKey(pr[1])) {
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count=0;

        for (int i=0;i<numCourses;i++) {
            if (indegree[i]==0) {
                queue.add(i);
                count++;
            }

        }
        if (count==numCourses) {
            return true;
        }
        if (queue.isEmpty()) {
            return false;
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> dep= map.get(cur);
            if (dep!=null) {
                for (int i : dep) {
                    indegree[i]--;
                    if (indegree[i]==0) {
                        queue.add(i);
                        count++;
                        if (count==numCourses) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

}
