//TC: O(V+E)
//SC: O(V+E)

//207. Course Schedule

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] indegree = new int[numCourses];
        for(int [] edge: prerequisites) {
            int out = edge[1];
            int in = edge[0];
            indegree[in]++;
            if(!map.containsKey(out)) {
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()) {
            int currcourse = q.poll();
            List<Integer> Children = map.get(currcourse);
            if(Children!=null) {
                for(int child: Children) {
                    indegree[child]--;
                    if(indegree[child]==0) {
                        q.add(child);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            } 
        }
        if(count == numCourses) return true;
        return false;
    }
}