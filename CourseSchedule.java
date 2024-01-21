class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for(int[] edge : prerequisites){
            int out = edge[1];
            int in = edge[0];
            indegrees[in]++;
            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        Queue<Integer> q = new LinkedList();
        int count = 0;
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        if(count == numCourses) return true;
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int course = q.poll();
            List<Integer> children = map.get(course);
            if(children != null) {
                for(int child : children){
                    indegrees[child]--;
                    if(indegrees[child] == 0){
                        q.add(child);
                        count ++;
                        if(count == numCourses) return true;
                    }
                }
            }
            
        }
        return false;
    }
}
