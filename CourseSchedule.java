// TIME: O(V + E)
// SPACE: O(V + E)
// SUCCESS on LeetCode

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegreeCount = new int[numCourses];
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            indegreeCount[prerequisites[i][0]]++;
            if (!adjList.containsKey(prerequisites[i][1])) {
                    adjList.put(prerequisites[i][1], new ArrayList<>());
            }
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        int count = 0;
        
        for (int i = 0; i < indegreeCount.length; i++) {
            if (indegreeCount[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        
        if (queue.isEmpty()) {
            return false;
        }
        
        while (!queue.isEmpty()) {
            int v = queue.poll();
            List<Integer> children = adjList.get(v);
            if (children != null) {
            for (Integer child : children) {
                indegreeCount[child]--;
                if (indegreeCount[child] == 0) {
                    queue.add(child);
                    count++;
                }
            }
            }
        }
        
        return count == numCourses;
    }
}