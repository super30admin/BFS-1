class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegrees = new int[numCourses];
        int count = 0;

        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            int to = prerequisite[0];
            int from = prerequisite[1];
            indegrees[to]++;

            if(!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        } 
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if (edges == null) {
                continue;
            }
            for (int i = 0; i < edges.size(); i++) {
                int edge = edges.get(i);
                indegrees[edge]--;
                if (indegrees[edge] == 0) {
                    q.add(edge);
                    count++;
                }
            }
        }
        return count == numCourses;
    }
}