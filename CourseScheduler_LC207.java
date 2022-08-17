class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //create a map to store pre-req : courses list
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        //create a indegree array to store how many prereqs each course has 
        int[] indegree = new int[numCourses];
        
        //for loop to populate hashmap and indegree arrays with
        
        for(int[] prereq :prerequisites){
            indegree[prereq[0]]++;
            if(!map.containsKey(prereq[1])){
                map.put(prereq[1], new ArrayList());
            }
            map.get(prereq[1]).add(prereq[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int count = 0; //to count number of courses taken
        //create a for loop to traverse the indegree array add course with no prereq in to the queue
        for(int i=0; i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()){
            return false;
        }
        if(count == numCourses){
            return true;
        }
        //start taking the courses
        while(!q.isEmpty()){
            //pop the first pre req course
           int pc = q.poll();
            //check the subjects the prereq is for
           List<Integer> children = map.get(pc);
            //if there is any subject then go and reduce the indegree of the course/ pre req count of the course
            if(children !=null){
                 for(int child : children){
                indegree[child]--;
                     //after the pre req is reduced check if its equal to 0 and add it to the queue and increement the counter
                if(indegree[child]==0){
                    q.add(child);
                    count++;
                    //if subject taken count is equal to tot num of subjects then return true
                    if(count == numCourses){
                        return true;
                    }
                }
            }
            }
           
        }
       return false; 
    }
}