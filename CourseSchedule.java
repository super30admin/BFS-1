//Time complexity:O(E+V)
//Space Complexity: O(E+V)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] inDegree = new int[numCourses];
        HashMap<Integer,List<Integer>> hashmap = new HashMap<>();
        
        for(int[] pre : prerequisites){
            int from = pre[1];
            int to = pre[0];
            
            inDegree[to]+=1;
            
            if(!hashmap.containsKey(from)){
                hashmap.put(from,new ArrayList<>());
            }
            hashmap.get(from).add(to);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int x=0;x<numCourses;x++){
            if(inDegree[x]==0){
                queue.add(x);
            }
        }
        
        while(!queue.isEmpty()){
            int front = queue.poll();
            
            if(hashmap.containsKey(front)){
            for(int x:hashmap.get(front)){
                inDegree[x]-=1;
                    if(inDegree[x]==0){
                        queue.add(x);
                    }
            }
            }
        }
        
        for(int x:inDegree){
            if(x!=0){
                return false;
            }
        }
        return true;
        }
}