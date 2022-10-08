// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;

        int[] degrees = new int [numCourses];
        HashMap<Integer, List<Integer>> theMap = new HashMap<>();
        int totalCount=0;

        for (int[] edge : prerequisites) {
            int to = edge[0];
            int from = edge[1];
            degrees[to]++;
            if (!theMap.containsKey(from)) {
                theMap.put(from, new ArrayList<>());
            }
            theMap.get(from).add(to);
        }
        System.out.println("HashMap:"+theMap);
        Queue<Integer> queue = new LinkedList<>();
        // start with elments that don't have a from and add them to the queue
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
                totalCount++;
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> edges = theMap.get(curr);
            if (edges != null) {
                for (int edge : edges) {
                    degrees[edge]--;
                    if (degrees[edge] == 0) {
                        queue.add(edge);
                        totalCount++;
                    }
                }
            }
        }

        return totalCount == numCourses;
    }
}
