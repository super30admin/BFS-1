Time Complexity: O(V+E)
Space Complexity: O(V+E)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> AdjList = new HashMap<>();
        
        //O(n) for-loop
        for(int[] x : prerequisites){
            int to = x[1];
            int from = x[0];
            
            inDegree[to]++;
            
            if(!AdjList.containsKey(from)){
                AdjList.put(from, new ArrayList<Integer>());
            }
            
            AdjList.get(from).add(to);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        //O(n) for-loop
        for(int x=0;x<numCourses;x++){
            if(inDegree[x] == 0){
                queue.add(x);
            }
            
        }   
        
        //O(V+E) 
        while(!queue.isEmpty()){
            int front = queue.poll();

            if(AdjList.containsKey(front)){
                for(int i : AdjList.get(front)){
                    inDegree[i]--;
                    if(inDegree[i] == 0){
                        queue.add(i);
                    }
                }

            }

        }
        for(int a : inDegree){
            if(a!=0){
                return false;
            }
        }
        return true;

    }
}
