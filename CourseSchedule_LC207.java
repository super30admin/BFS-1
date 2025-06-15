// Time Complexity : O(m) m is no. of preReq's ading it to map
// Space Complexity : O(m + n) m is no. of preReq's & n is no. of courses for the saving in map.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES


class CourseSchedule_LC207 {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    boolean[] visited;
    boolean[] path;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        path = new boolean[numCourses];

        for (int[] preReq : prerequisites) {
            int a = preReq[0]; // course that depends on b
            int b = preReq[1]; // prerequisite

            // map.computeIfAbsent(preReq[1], k -> new ArrayList<>()).add(preReq[0]); // b → a
            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(a);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && dfs(i)) {
                return false; // found cycle
            }
        }

        return true;
    }

    private boolean dfs(int i){
        if (path[i]) return true; // cycle detected
        if (visited[i]) return false;

        visited[i] = true;
        path[i] = true;

        if (map.containsKey(i)) {
            for (int neighbor : map.get(i)) {
                if (dfs(neighbor)) return true;
            }
        }

        path[i] = false;
        return false;
    }

}