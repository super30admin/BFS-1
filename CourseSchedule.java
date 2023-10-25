// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class CourseSchedule {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            int inDegree[] = new int[numCourses];

            for(int[] pre : prerequisites){
                int independent = pre[1];
                int dependent = pre[0];

                if(!map.containsKey(independent)){
                    List<Integer> list = new ArrayList<>();
                    map.put(independent, list);
                }
                map.get(independent).add(dependent);
                inDegree[dependent]++;
            }

            int count = 0;
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < numCourses; i++){
                if(inDegree[i] == 0){
                    q.add(i);
                    count++;
                }
            }
            //no dependent course, can take every courses
            if(count == numCourses)
                return true;
            //all dependent courses on each other
            if(q.isEmpty())
                return false;

            while(!q.isEmpty()){
                int popped = q.poll();
                List<Integer> li = map.get(popped);
                //null dependencies
                if(li == null)
                    continue;
                for(int l : li){
                    inDegree[l]--;
                    if(inDegree[l] == 0){
                        q.add(l);
                        count++;
                    }
                }
            }
            return count == numCourses;
        }
    }
}
