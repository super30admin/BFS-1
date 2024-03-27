/*
Approach : start with course which has 0 dependency, calculate indegree array. Add it to queue. 
Pop out the independent course and reduce the indegree of it's dependants by 1.  Maintain a map to get the dependent nodes for each node
add the node to queue if indegree becomes 0
TC: O(V+E) - no. of courses + edges
SC: O(V+E) which we store in the map
*/
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> m = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites ){
            int in = edge[0];
            int out = edge[1];
            indegree[in]++;
        if(!m.containsKey(out)){
            m.put(out, new ArrayList<>());
        }
        m.get(out).add(in);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
                count++;
            }
        }
        if (count == numCourses) return true;
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = m.get(curr);
            if(children != null){
                for (int child : children){
                    indegree[child]--;
                    if(indegree[child] == 0){
                        q.add(child);
                        count++;
                        if (count == numCourses) return true;
                    }
                }
            }
        }
    return false;
    }
}