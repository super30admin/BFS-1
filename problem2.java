    /**
    Time Complexity : O(V + E)
    Explanation:
    V = number of courses
    E = number of prerequisite relations
    We build the graph once and process each node and edge once
    using Kahn’s Algorithm (Topological Sort with BFS).

    Space Complexity : O(V + E)
    Explanation:
    - HashMap stores adjacency list of the graph
    - Queue stores nodes with 0 indegree
    - indegree array stores dependency count

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about how to represent course dependencies.
    Later implemented it as a directed graph where:
        prerequisite → dependent course
    Then applied Kahn’s Algorithm using indegree tracking.
    Also needed a counter to check if all courses are processed,
    which confirms there is no cycle.
    */

    class Solution {



        public boolean canFinish(int numCourses, int[][] prerequisites) {
    
            Queue<Integer> q = new LinkedList<>();
            int n = numCourses;
    
            int[] inDeg = new int[n];
            HashMap<Integer, List<Integer>> map = new HashMap<>();
    
            int cnt = 0;
    
            // Build graph and indegree array
            for (int[] edge : prerequisites) {
    
                int dep = edge[0];
                int ind = edge[1];
    
                if (!map.containsKey(ind)) {
                    map.put(ind, new ArrayList<>());
                }
    
                map.get(ind).add(dep);
                inDeg[dep]++;
            }
    
            // Add nodes with indegree 0 to queue
            for (int i = 0; i < n; i++) {
                if (inDeg[i] == 0) {
                    q.add(i);
                    cnt++;
                }
            }
    
            if (cnt == n) return true;
            if (map.isEmpty()) return true;
    
            // BFS for topological sort
            while (!q.isEmpty()) {
    
                int size = q.size();
    
                for (int i = 0; i < size; i++) {
    
                    int curr = q.poll();
                    List<Integer> depli = map.get(curr);
    
                    if (depli != null) {
    
                        for (int k : depli) {
    
                            inDeg[k]--;
    
                            if (inDeg[k] == 0) {
                                q.add(k);
                                cnt++;
    
                                if (cnt == n) return true;
                            }
                        }
                    }
                }
            }
    
            return false;
        }
    }