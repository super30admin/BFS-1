// time - O(V+E)
// space - O(V+E)

class CourseSchedule{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        // create indegree and map for all dependencies
        for(int[] prerequisite: prerequisites){
            int in = prerequisite[0]; // incoming edges
            int out = prerequisite[1]; // outgoing edges
            indegrees[in]++;
            if(!map.containsKey(out))
                map.put(out, new ArrayList<>());
            map.get(out).add(in);
        }

        //find independent vertices and add to queue
        for(int i=0; i< indegrees.length; i++){
            if(indegrees[i] == 0)
                q.add(i);
        }

        // process edges
        while(!q.isEmpty()){
            int cur = q.poll();
            count++;

            //get children
            List<Integer> children = map.get(cur);
            if(children != null){
                for(int child: children){
                    indegrees[child]--;
                    if( indegrees[child] == 0){
                        q.add(child);
                    }
                }
            }
        }
        return count == numCourses;

    }
}