// Time Complexity: O(V+E)
// Space Complexity: O(v+E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] prerequisite: prerequisites){
            indegrees[prerequisite[0]]++;
            List<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1], list);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegrees[i] == 0){
                q.add(i);
            }
        }

        if(q.isEmpty()) {
            return false;
        }

        while(!q.isEmpty()) {
            int course = q.poll();
            List<Integer> children = map.get(course);
            if(children != null) {
                for(int child: children) {
                    indegrees[child]--;
                    if(indegrees[child] == 0) {
                        q.add(child);
                    }
                }
            }
        }

        for(int i: indegrees) {
            if(i > 0) {
                return false;
            }
        }

        return true;
    }
}