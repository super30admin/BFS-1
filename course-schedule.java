class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        if (prerequisites.length == 0) return true;

        for(int[] edge: prerequisites){
            int in = edge[1];
            int out = edge[0];
            indegrees[in]++;

            if(!map.containsKey(out)){
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
            Queue<Integer> q = new LinkedList<>();
            int count = 0;
            for(int i = 0; i<numCourses; i++){
                if(indegrees[i] == 0){
                    q.add(i);
                    count++;       
                }
            }
            if(q.isEmpty()) return false;
            
            while(!q.isEmpty()){
                int curr = q.poll();
                List<Integer> children = map.get(curr);
                if (children != null) {
                    for(int child: children){
                        indegrees[child]--;
                        if(indegrees[child] == 0){
                            q.add(child);
                            count++;
                            if(count == numCourses) return true;
                            
                        }
                    }
                }
            }
            
        
    return false;
    }
}

//Time Complexity: O(V + E) 
//Space Complexity: O(V + E)
//V - number of courses, E - number of prerequisites