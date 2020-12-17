/* Time Complexity : O(V+E) V represents number of courses and Edges are number of prerequisite edges
 space complexity : O(N)
 * Idea : Model it as directed graph and push into queues whenever indegrees is 0. this will reduce indegree of other
 courses and hence again repeat the process. If graph has no cycle then u will always complete all courses.
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] prerequisite : prerequisites){
            indegree[prerequisite[0]]++;
            map.computeIfAbsent(prerequisite[1],k->new ArrayList<Integer>()).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
    
        int count_course_taken = 0;
        while(!queue.isEmpty()){
            int course_taken = queue.poll();
            count_course_taken++;
            if(map.containsKey(course_taken)){
                for(int prerequisite : map.get(course_taken)){
                    indegree[prerequisite]--;
                    if(indegree[prerequisite] == 0){
                        queue.add(prerequisite);
                    }
               }
            }
        }
        return count_course_taken==numCourses;
    }
}