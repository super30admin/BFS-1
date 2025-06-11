// Time Complexity O(V+E)
// Space Complexity O(V+E)
// Runs on LeetCode YES

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int[] indegrees = new int[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();
        int count = 0;
        for (int[] edges : prerequisites) {
            int out = edges[1]; // independent
            int in = edges[0]; // dependants

            indegrees[in] = indegrees[in] + 1;

            if (map.get(out) == null) {
                map.put(out, new ArrayList<Integer>());
            }

            map.get(out).add(in);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }

        while (!q.isEmpty()) {
            int currentCourse = q.poll();
            //map lookup
            ArrayList<Integer> dependets = map.get(currentCourse);

            if (dependets != null) {
                // reduce in indegrees
                for (int i : dependets) {
                    indegrees[i] = indegrees[i] - 1;
                    if (indegrees[i] == 0) {
                        q.add(i);
                        count++;
                        if (count == numCourses) {
                            return true;
                        }
                    }
                }
            }

        }
        if (count == numCourses) {
            return true;
        }
        return false;

    }
}