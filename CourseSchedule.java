//Time Complexity :O(N^2)
//Space Complexity :O(N)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach
class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        int degree[] = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses;i++){graph[i]= new ArrayList<>();}
        for(int i = 0; i < prerequisites.length; i++){
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i = 0; i < degree.length; i++){
            if(0 == degree[i]){
                q.offer(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            int course = q.poll();
            for(int i = 0; i < graph[course].size(); i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(0 == degree[pointer]){
                    q.offer(pointer);
                    count++;
                }
            }
        }
    return count == numCourses;
    }
}