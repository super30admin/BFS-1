class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int [] indegrees = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        for(int [] req : prerequisites){
            int in = req[0];
            int out = req[1];
            indegrees[in]++;
            
            if(!map.containsKey(out)){
                map.put(out,new ArrayList<Integer>());
            }
            map.get(out).add(in);
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i]==0){
                q.offer(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            
            int temp = q.poll();
            count++;
            if(map.containsKey(temp)){
                for(int e : map.get(temp)){
                    indegrees[e]--;
                    if(indegrees[e]==0) q.offer(e);
                }
            }                        
        }
        
        return count == numCourses;
        
        
    }
}