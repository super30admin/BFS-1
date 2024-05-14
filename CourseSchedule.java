// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int count=0;
        for(int[] pre : prerequisites) { // O(E) // no. of edges
            indegrees[pre[0]]++;

            if(!map.containsKey(pre[1])) {
                map.put(pre[1], new ArrayList<>());
            }

            map.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i< indegrees.length;i++) { // O(V) // no. of vertices

            if(indegrees[i] == 0) {
                q.add(i);
                count++;
            }

        }

        if(count == numCourses) return true;

        while(!q.isEmpty()){ // O(V+E)
            Integer course = q.poll();

            List<Integer> li = map.get(course);

            if(li != null){
                for(int i: li) {
                    indegrees[i]--;
                    if(indegrees[i] == 0) {
                        q.add(i);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }

        return false;
    }
}