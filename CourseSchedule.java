// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        int count = 0;

        for(int[] pr : prerequisites) {
            indegrees[pr[0]]++;
            if(!map.containsKey(pr[1])) {
                map.put(pr[1], new ArrayList<>());
            }
            map.get(pr[1]).add(pr[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while(!queue.isEmpty()) {
            int currCourse = queue.poll();
            List<Integer> li = map.get(currCourse);

            if(li != null) {
                for(int c : li) {
                    indegrees[c]--;
                    if(indegrees[c] == 0) {
                        queue.add(c);
                        count++;
                    }
                }
                
            }
        }
        return count == numCourses;
    }
}