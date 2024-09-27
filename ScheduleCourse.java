// Time Complexity : O(V+E) indegrees length and hashmap has the edges ..where E is the number of (prerequisities) and V is the number of vertices(courses)
// Space Complexity : O(V+E) where E is the number of (prerequisities) and V is the number of vertices(courses)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
first we create a adjacency list(hashmap with k as the course number and v is the children which are dependent on this course) and indegrees array 
then we add all those courses whose indegree is 0 to the queue

until queue is empty we keep on polling the elements from the queue
do count++ also.. as this element has reached indegree = 0 and we have added its children(whose indegrees=0) as well

then we see if it has any dependent courses or not, if it has .. decrement for all dependent_courses **--indegree(dependent_course)** 
after decrement see if indegree = 0  for that dependent course ,if yes add it to queue(since its prerequisites have been visited)
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> children = new HashMap<>();

        // TC O(E) where E is the number of (prerequisities)edges in the graph and V is
        // the number of courses(vertices)
        for (int n[] : prerequisites) {
            int start = n[1], end = n[0];
            indegrees[end]++;
            if (!children.containsKey(start)) {
                children.put(start, new ArrayList());
            }
            // since array is passed by reference
            children.get(start).add(end);
        }

        // Topological Sort
        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegrees.length; i++)
            if (indegrees[i] == 0)
                q.offer(i);

        // TC O(V+E) where E is the number of (prerequisities)edges in the graph and V
        // is the number of courses(vertices)
        // becuse the while loop will run for all vertices which is O(V)
        // and the for loop goes till number of prerequisites .. and + not X because it
        // will not be for all the vertices
        while (!q.isEmpty()) {
            int temp = q.poll();
            count++;
            // see if there is any child or not
            if (children.containsKey(temp)) {
                for (int i : children.get(temp)) {
                    if (--indegrees[i] == 0)
                        q.offer(i);
                }
            }

        }

        // here count is the number of courses we can take which have no cycles or
        // backedges
        return count == numCourses;

    }
}