// Time Complexity  : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : prerequisites) {
            indegree[edge[0]]++;
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        if (count == 0) {
            return false;
        }
        while (!queue.isEmpty()) {
            int num = queue.poll();
            List<Integer> children = map.get(num);
            if (children != null) {
                for (int child : children) {
                    indegree[child]--;
                    if (indegree[child] == 0) {
                        queue.add(child);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}