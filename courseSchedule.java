import java.util.*;


//207. Course Schedule
//TC: O(E+V)
//SC: O(E+V)
class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return false;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        //populating indegree array and hashmap simultaneously
        for (int[] prerequisite : prerequisites) {
            int to = prerequisite[0];
            int from = prerequisite[1];
            inDegree[to]++;
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }
        for (int i=0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                cnt++;
            }
        }
        //BFS and no need of size variable
        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if (edges == null) {
                continue;
            }
            for (int e : edges) {
                inDegree[e]--;
                if (inDegree[e] == 0) {
                    q.add(e);
                    cnt++;
                }
            }

        }
        //either traverse over indegree array or check cnt variable
        return cnt == numCourses;
    }
}