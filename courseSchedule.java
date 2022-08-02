// Time Complexity :O(V+E) where v is no of vertices and e is no of edges
// Space Complexity :V+E
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        // make ingedrees array
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]] += 1;
        }
        // create graph /relation hashmap

        for (int i = 0; i < prerequisites.length; i++) {
            int dependent = prerequisites[i][0];
            int dependee = prerequisites[i][1];
            if (!graph.containsKey(dependee)) {
                List<Integer> temp = new ArrayList<>();
                graph.put(dependee, temp);
            }
            graph.get(dependee).add(dependent);
        }
        // add sources in queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            // get dependents list of current node
            List<Integer> temp = graph.get(curr);
            System.out.println(temp);
            if (temp != null) {
                for (int i : temp) {
                    // decrease indegrees by 1 of dependents
                    indegree[i] -= 1;
                    if (indegree[i] == 0) {// add it to queue if indegree beconmes 0
                        q.add(i);
                    }
                }
            }
            if (count == numCourses) {
                return true;
            }

        }

        return false;
    }
}