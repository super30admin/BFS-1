// Time complexity :O(E+V)
// space complexity :O(E+V)
// leetcode : success

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] dependency = new int[numCourses];
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0 ; i < prerequisites.length ; i++){
            dependency[prerequisites[i][1]]++; 
            
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0],new ArrayList<>());
            }
            
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        for(int i = 0 ; i < numCourses ; i++){
            if(dependency[i]==0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            
            int currCourse = queue.poll();
            
            List<Integer> children = map.get(currCourse);
            
            if(children != null){
                for(int child : children){
                    
                    dependency[child]--;
                
                    if(dependency[child] == 0){
                 
                        queue.add(child);
                        
                    }
                }
            } 
        }
        
         for(int i = 0 ; i < numCourses ; i++){
            if(dependency[i]!=0){
                return false;
            }
        }
        
        return true;
    }
}