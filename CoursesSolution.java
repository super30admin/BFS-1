class CoursesSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        //create an indegrees array
        int[] indegrees = new int[numCourses];
        //create a hashmap to store the independent:dependent courses
        HashMap<Integer,List<Integer>> map = new HashMap();
        //iterate the prequisite i.e. independent vs dependent to populate the map
        for (int[] edge:prerequisites) {
            indegrees[edge[0]]++;
            System.out.println("indegrees[edge[0]]==="+indegrees[edge[0]]);
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<Integer>());
            }
            
            map.get(edge[1]).add(edge[0]);
        }
        //Queue To add the completed courses
        Queue<Integer> q = new LinkedList<Integer>();
        //no. of courses completed
        int count = 0;
        
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
                count++;
            }           
        }
        
        //proces the queue
        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> li = map.get(curr);
            
            if (li != null) {
                for (int depCourses:li){
                    indegrees[depCourses]--;
                    if (indegrees[depCourses] == 0) {
                        q.add(depCourses); 
                        count++;
                        if (count==numCourses) return true;
                    }
                    
                }
            }
            
        }
        
     return false;   
    }
}