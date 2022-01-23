class Solution {
    // Time Complexity : O(V+E), where V is the no of vertices and E is the no of edges
    // Space Complexity : O(V+E)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach: Using BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int count = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] e : prerequisites) {
            indegree[e[0]]++;
            if(!map.containsKey(e[1])) {
                map.put(e[1], new ArrayList<>());
            }
            map.get(e[1]).add(e[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
                count++;
            }
        }

        if(q.isEmpty()) return false;

        while(!q.isEmpty()) {
            int k = q.poll();
            List<Integer> neighbors = map.get(k);
            if(null != neighbors) {
                for(int n : neighbors) {
                    indegree[n]--;
                    if(indegree[n] == 0) {
                        q.add(n);
                        count++;
                    }
                }
            }
        }
        return count==numCourses;
    }
}

// Time Complexity : O(V+E), where V is the no of vertices and E is the no of edges
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: Using DFS
class Solution {
    enum Status {
        NOT_VISITED, VISITED, VISITING;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] e : prerequisites) {
            if(!map.containsKey(e[1])) {
                map.put(e[1], new ArrayList<>());
            }
            map.get(e[1]).add(e[0]);
        }

        Status[] st = new Status[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(dfs(st, map, i)) return false;
        }
        return true;
    }

    public boolean dfs(Status[] st, HashMap<Integer, List<Integer>> map, int i) {
        if(st[i] == Status.VISITING) return true;
        if(st[i] == Status.VISITED) return false;

        st[i] = Status.VISITING;
        if(null != map.get(i)) {
            for(int k : map.get(i)) {
                if(dfs(st, map, k)) return true;
            }
        }
        st[i] = Status.VISITED;
        return false;
    }
}