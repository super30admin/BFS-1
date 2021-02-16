class CourseSchdule{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        
        for(int[] x : prerequisites){
            int to = x[1];
            int from = x[0];
            
            inDegree[to] += 1;
            
            if(!hashMap.containsKey(from)){
                hashMap.put(from, new ArrayList<>());
            }
            
            hashMap.get(from).add(to);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int x=0; x<numCourses; x++){
            if(inDegree[x] == 0){
                queue.add(x);
            }
        }
        
        while(!queue.isEmpty()){
            int front = queue.poll();
            
            if(hashMap.containsKey(front)){
                for(int x : hashMap.get(front)){
                    inDegree[x] -= 1;
                    if(inDegree[x] == 0){
                        queue.add(x);
                    }
                }
            }
        }
        
        
        for(int x:inDegree){
            if(x != 0){
                return false;
            }
        }
        
        return true;
        
        
    }
}