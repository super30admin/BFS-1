/*
    LC - 207. Course Schedule
    TC - O(V + E)
    SC - O(V + E)

    V - denotes vertices of the graph
    E - denotes edges of the graph
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegrees[] = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            indegrees[to]++;
            if(!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }
        for(int i=0; i<numCourses; i++) {
            if(indegrees[i] == 0) {
                q.add(i);
                count++;
            } 
        }
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(!map.containsKey(curr)) {
                continue;
            }
            List<Integer> edges = map.get(curr);
            for(int edge : edges) {
                if(indegrees[edge] > 0) {
                    indegrees[edge]--;
                    if(indegrees[edge] == 0) {
                        q.add(edge);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}