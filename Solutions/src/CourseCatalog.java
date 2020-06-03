// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
class CourseCatalog {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> graph = new HashMap();
        for(int i=0;i<numCourses;i++){
            graph.put(i,new LinkedList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] tuple: prerequisites){
            int course = tuple[0];
            int prerequisite = tuple[1];
            graph.get(prerequisite).add(course);
            indegree[course]++;

        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count =0;
        while (!q.isEmpty()){
            int currentcourse = q.poll();
            List<Integer> correspond = graph.get(currentcourse);
            for(int course: correspond){
                indegree[course]--;
                if(indegree[course]==0){
                    q.add(course);
                }
            }
            count++;
        }
        if(count == numCourses ){
            return true;
        }
        return false;
    }
}
