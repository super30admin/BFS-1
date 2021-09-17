class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int [] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
       
        
//         int rows = prerequisites.length;
//         int cols = prerequisites[rows - 1].length;
        
//         System.out.println("Rows: "+rows+", Cols: "+cols);
        
//         for (int i=0; i<prerequisites.length; i++){
            
//             for (int j=0; j<prerequisites[i].length; j++){
//                 System.out.println("prerequisites[i][j]: "+prerequisites[i][j]);
//             }
            
//         }
        for (int [] edge: prerequisites) {
            System.out.println("Edge[0]: "+edge[0]+", Edge[1]: "+edge[1]);
            indegrees[edge[0]]++;
            
            if (!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]); 
        }
        
        Queue<Integer> q = new LinkedList<>();
        int count=0;
        
        for (int i=0; i<indegrees.length; i++){
            
            if (indegrees[i] == 0){
               q.add(i); 
                count++;
            }
        }
        
        while (!q.isEmpty()){
            int curr = q.poll();
            //Take list of all courses which were dependent on the current courses and reduce their indegree count
            
            List<Integer> children = map.get(curr);
            
            if (children != null){
                for (int child: children){
                    indegrees[child]--;
                    if(indegrees[child] == 0){
                        q.add(child);
                         count++;
                    }
                }
            }
        }
        
      
        return count == numCourses ;
        
    }
}
