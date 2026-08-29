
// using BFS
// O(V+E) time complexity
// O(V+E) space complexity


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int[] pre : prerequisites){
            //independent // dependent
          map.putIfAbsent(pre[1], new ArrayList<>());
          map.get(pre[1]).add(pre[0]);
          inDegrees[pre[0]]++;
        }

        for(int i = 0; i< numCourses; i++){
            if(inDegrees[i] == 0){
                q.add(i);
                count++;
            }
        }

        if(count == 0) {
            return false;
        }
        if(count == numCourses) {
            return true;
        }

       
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> dependencies = map.get(curr);
            if(dependencies != null){
                for(int dependent : dependencies){
                    inDegrees[dependent]--;
                    if(inDegrees[dependent] == 0){
                        q.add(dependent);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }

        return false;
    }
        
    
    
}
