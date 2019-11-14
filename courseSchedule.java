/*207. Course Schedule
Time Complexity: O(V * E) where V is the number of courses
Space Complexity: O(V)
Optimised approach use a hashMap
*/


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in_degrees = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            in_degrees[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<in_degrees.length; i++){
            if(in_degrees[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int course = q.poll();

            for(int i=0; i<prerequisites.length; i++){
                if(prerequisites[i][1] == course){
                    in_degrees[prerequisites[i][0]]--;
                    if(in_degrees[prerequisites[i][0]] == 0)
                        q.add(prerequisites[i][0]);
                }
            }
        }
        for(int i=0; i<in_degrees.length; i++){
            if(in_degrees[i] != 0)
                return false;
        }

        return true;
    }
}