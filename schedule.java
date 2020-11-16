//Time complexity: O(v+e)
//Space complexity: O(m*n) 
//Program ran successfully
/*
    Algorithm: 1. Find out the incoming edges at each courses(find dependencies)
               2. Create a mapping from the course to the list of courses it affects.
               3. Add courses which have zero dependencies into the queue and decrement the incoming edges of it's children
               4. If the children becomes independent, add it to the queue
               5. Finally, if all nodes become independent return true else return false.
*/

class schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            indegrees[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child: children){
                    indegrees[child]--;
                    if(indegrees[child] == 0){
                        q.add(child);
                    }
                }
            }      
        }
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] > 0) return false;
        }
        return true;
    }
}
