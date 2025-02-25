class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        HashMap<Integer, List<Integer>> map= new HashMap<>();
        Queue<Integer> queue= new LinkedList<>();
        int[] indegree= new int[numCourses];
        int length= prerequisites.length;
        for(int i=0;i<length;i++){
            int ind= prerequisites[i][1];
            int dep= prerequisites[i][0];
            indegree[dep]++;
            if(!map.containsKey(ind)){
                map.put(ind,new ArrayList<>()) ;
            }
            map.get(ind).add(dep);

        }
        int count=0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
                count++;
            }
        }
        if(count==numCourses) return true;
        if(count==0) return false;
        while(!queue.isEmpty()){
            int course=   queue.poll();
            //    List<Integer> curr=map.get(course);
            List<Integer> curr = map.getOrDefault(course, new ArrayList<>());
            for(Integer child: curr){

                indegree[child]--;
                if(indegree[child]==0){
                    queue.add(child);
                    count++;
                    if(count ==numCourses) return true;
                }
            }

        }
        return false;
    }
}