// Time complexity - O(V+E)
// Space complexity - O(V+E) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
     boolean result = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
       boolean[] visited = new boolean[numCourses];
        HashMap<Integer,ArrayList> map1 = new HashMap<>();
       // Queue<Integer> q1 = new LinkedList<>();
        
        for(int i = 0; i < prerequisites.length; i ++){
            
           if(!map1.containsKey(prerequisites[i][1])){
               
               map1.put(prerequisites[i][1],new ArrayList<Integer>());
           }
            
            map1.get(prerequisites[i][1]).add(prerequisites[i][0]);
           // indegreeArray[prerequisites[i][0]]++;
        }
         boolean[] path = new boolean[numCourses];
        for(int i = 0; i < numCourses; i ++){
            if(result == false){
                
                return result;
            }
            
            if(visited[i] == false){
                
            // System.out.println("hitting ------------------new call-----------------");
                 
            
              dfs(i, visited, map1,path);
               // visited[i] = false;
            if(result == false){
                
                return result;
            }
              
            }
        }
        return result;
    }
    
    private void dfs(int i, boolean[] visited, HashMap<Integer,ArrayList> map1, boolean[] path){
               
        //base case
            if(result == false){
                
                return;
            }
             //  System.out.println("hitting and i is"+ i);
        
        //logic
            if(visited[i] == false){
             
                visited[i] = true;
                path[i] = true;
                if(map1.containsKey(i)){
            //    System.out.println("hitting and i is"+ i);
                ArrayList<Integer> value = new ArrayList<>();
                 value = map1.get(i);
              //  System.out.println("value of i is"+ value);
                    
                
                    for(int j = 0; j < value.size(); j ++){
                        
                        if(path[value.get(j)] == true){
                        //    System.out.println("is it false???");
                            result = false;
                            return;
                        }
                        
                        else{
                            
                            path[value.get(j)] = true;
                            dfs( value.get(j), visited, map1, path);
                        }
                    }
                    
                }
    
        }
        
        //visited[i] = false;
        //backtrack
        path[i] = false;
        if(result == false){
            return;
        }
    }
}