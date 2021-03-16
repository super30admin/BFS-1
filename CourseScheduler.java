// TC - O(V + E), SC - O(V + E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
            
        int[] inDegree = new int[numCourses]; 
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] x : prerequisites){
            int to = x[1];
            int from = x[0];
            inDegree[to]++;
            if(!map.containsKey(from)){
                map.put(from, new ArrayList<Integer>());
            }
            map.get(from).add(to);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int x=0; x<numCourses; x++){
            if(inDegree[x] == 0){
                q.add(x);
            }
        }
        
        while(!q.isEmpty()){
            int front = q.poll();
            if(map.containsKey(front)){
                for(int x : map.get(front)){
                    inDegree[x]--;
                    if(inDegree[x] == 0){
                        q.add(x);
                    }
                }
            }
        }
        
        for(int x : inDegree){
            if(x != 0){
                return false;
            }
        }
        return true;
    }
}