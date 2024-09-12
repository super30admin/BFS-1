/*
Time Complexity : O(V+E) where V is the number of vertices and E is number of edges
Space Complexity - O(V) - V is number of courses
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create map 
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();  
        
        int []indegree = new int[numCourses];
        
        for(int [] course :prerequisites){
            indegree[course[0]]++;
            if(!map.containsKey(course[1]))
                map.put(course[1], new ArrayList<>());
            map.get(course[1]).add(course[0]);
        }
             
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i< numCourses; i++)
            if(indegree[i] == 0)
                q.add(i);

        if(q.isEmpty())
            return false;
        
        while(!q.isEmpty()){
            //remove the course from the q, means I am taking this course now. 
            int course = q.poll();
            //after taking this course I can take all the courses for which this course is prereq, 
            //as I would be decreasing its count in indegree array means 1 as one of the dependency is             removed.
            List<Integer> list = map.get(course);
            if(list != null){
                for(int i: list){
                    indegree[i]--;
                    //once indegree becomes zero, it means all the prereqs are already taken
                    //we can take the course now. so add it to queue now.
                    if(indegree[i] == 0)
                        q.add(i);
                }
            }
        }
        //after processing of all the courses if all indegree of all the courses is zero 
        //we can finish all the courses
        for(int i: indegree)
            if(i >  0) return false;
        
        return true;
    }
}

