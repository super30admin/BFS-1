/*
T: O(V+E)
S: O(V+E) : hashmap(V+E) + indegrees(V) + queue(V) -> E+3V => O(V+E)
where V = no of courses
E = no of edges -> size of prereq array
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build in-degree array to find independent nodes
        int[] indegrees = new int[numCourses];
        
        //build a map of courses: prereq -> next course
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] prereq: prerequisites){
            int post = prereq[1];
            int pre = prereq[0];
            map.computeIfAbsent(post, i -> new ArrayList<>()).add(pre); 
            
            //update indegrees array
            indegrees[pre]++;
 
        }
        
        int count = 0; // no of courses finished
        Queue<Integer> q = new LinkedList<>();
        //add all independent nodes to the queue
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0)
                q.add(i);
        }
        
        //return if no independent nodes i.e. q is empty
        if(q.isEmpty()) return false;
        
        //now take the independent nodes out and reduce the dependency of post courses
        while(!q.isEmpty()){
            int pre = q.poll();
            count++; //finished the course
            //update indegrees
            List<Integer> courses = map.get(pre);
            if(courses != null){
                for(int c: courses){
                indegrees[c]--;
                if(indegrees[c] == 0)
                    q.add(c);
                }   
            }
        }
        
        return count == numCourses ? true : false;
    }
}