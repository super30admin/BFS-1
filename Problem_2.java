// Time Complexity : O(V + E)
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We make use of independent courses and add them to queue. Then we iterate on each independent course and remove the outgoing
   edges. Now for next round the courses whose indegree is 0 are again added to the queue. In the end we check if no of courses added
   to queue are equal to numCourses that have to be taken. If they are equal we return true else we return false.
*/

class Solution {
   public boolean canFinish(int numCourses, int[][] prerequisites) {
       int[] indegrees = new int[numCourses];
       
       Map<Integer, List<Integer>> hMap = new HashMap<>();

       
       for(int[] prerequisite : prerequisites) {
           indegrees[prerequisite[0]]++;
           if(hMap.get(prerequisite[1]) == null)
               hMap.put(prerequisite[1], new ArrayList<>());

           hMap.get(prerequisite[1]).add(prerequisite[0]);
       }
       
       int count = 0;
       Queue<Integer> q = new LinkedList<>();

       for(int i = 0; i < numCourses; ++i) {
           if(indegrees[i] == 0) {
               q.add(i);
               count++;
           }
       }

       if(q.isEmpty())
           return false;

       while(!q.isEmpty()) {
           int course = q.poll();
           for(int c : hMap.getOrDefault(course, new ArrayList<>())) {
               indegrees[c]--;
               if(indegrees[c] == 0) {
                   q.add(c);
                   count++;
                   if(count == numCourses)
                       return true;
               }
           }
       }
       
       return count == numCourses;
   }
}

