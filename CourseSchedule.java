// Time Complexity : 0(V+E)
// Space Complexity : 0(V+E) for hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Didn't think about storing <V,E> in hashmap which avoids
// iterating through array again and again

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        //for counting which courses have dependency
        int indegree[] = new int[numCourses];

        //storing dependency of a given course
        //eg. 0 -> [2,4] means to take course 2 & 4, we need to take 0
        Map<Integer, List<Integer>> map = new HashMap<>();

        //filling indegrees and map
        for (int[] edge : prerequisites){
            indegree[edge[0]]++;
            if(!map.containsKey(edge[1]))
                map.put(edge[1], new ArrayList<Integer>());
            map.get(edge[1]).add(edge[0]);
        }

        //add course to queue when it is independent i.e. indegree == 0
        Queue<Integer> queue = new LinkedList<Integer>();

        int count = 0;

        //add all independent courses
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.add(i);

        //iterate through the queue
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            //iterate through dependent courses of independent courses
            List<Integer> edges = map.get(cur);
            if(edges != null){
                for(int edge : edges){
                    indegree[edge]--;
                    //put course in queue if independent now
                    if(indegree[edge] == 0){
                        queue.add(edge);
                    }
                }
            }
        }

        //see if count matches with total number of courses
        return count == numCourses;

    }
}