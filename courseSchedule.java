// Time Complexity : O(EV) where E are the edges and V are the vertices of the graph formed using preReq array
// Space Complexity : O(E+V) where E are the edges and V are the vertices of the graph formed using preReq array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// BFS using queue

class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            inDegrees[prerequisites[i][0]]++;
            if (!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int course = q.poll();
            List<Integer> children = map.get(course);
            if (children != null) {
                for (int child : children) {
                    inDegrees[child]--;
                    if (inDegrees[child] == 0) q.add(child);
                }
            }
        }
        for (int num : inDegrees) {
            if (num > 0) return false;
        }
        return true;
    }
}