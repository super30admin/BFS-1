// Time Complexity : O(|V| + |E|) where V is no of Vertices and E is Edges in graph
// Space Complexity : O(|V| + |E|)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites == null || prerequisites.length
                == 0)
            return true;

        //build graph adj-list
        Map<Integer, List<Integer>> map = new HashMap<>();

        //in-degrees array
        int[] indegrees = new int[numCourses];

        for(int[] prereq : prerequisites) {
            int out = prereq[1];
            int in = prereq[0];

            if(!map.containsKey(out))
                map.put(out, new ArrayList<>());
            map.get(out).add(in);
            indegrees[in]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        //independent courses
        for(int i=0; i<numCourses; i++) {
            if(indegrees[i] == 0)
                queue.add(i);
        }

        if(queue.isEmpty()) return false;
        if(queue.size() == numCourses) return true;

        int completed = 0;

        while(!queue.isEmpty()) {
            int prereq = queue.poll();
            completed++;
            List<Integer> courses = map.get(prereq);
            if(courses != null) {
                for(int course: courses) {
                    indegrees[course]--;

                    if(indegrees[course] == 0) {
                        queue.add(course);
                    }
                }
            }

        }

        return completed == numCourses;

    }
}