// Time complexity - O(V+E)
// Space complexity - O(n) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegreeArray = new int[numCourses];
        HashMap<Integer,ArrayList> map1 = new HashMap<>();
        Queue<Integer> q1 = new LinkedList<>();
        
        for(int i = 0; i < prerequisites.length; i ++){
            
           if(!map1.containsKey(prerequisites[i][1])){
               
               map1.put(prerequisites[i][1],new ArrayList<Integer>());
           }
            
            map1.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegreeArray[prerequisites[i][0]]++;
        }
        //check all independent nodes (indegrees == 0) and add it to queue
        for(int i = 0; i < indegreeArray.length; i ++){
            
            if(indegreeArray[i] == 0){
                
                q1.add(i);
            }
        }
        if(q1.isEmpty()){return false;}
        while(!q1.isEmpty()){
            //add the ingree=0 node and reduce the dependency in adjacency list hashmap because the dependency of courses would reduce when this current course is taken.
            int tempKey = q1.poll();
            
         //   System.out.println("tempKey is is " + tempKey);
            if(map1.containsKey(tempKey)){
               ArrayList<Integer> value = new ArrayList<>();
                 value = map1.get(tempKey);
              //  System.out.println("value is " + value);
                for(int i = 0; i < value.size(); i ++){
                    
                    int index = value.get(i);
                   //  System.out.println("indegreeArray[i]" + indegreeArray[index]);
                    indegreeArray[index] = indegreeArray[index] - 1;
                    if(indegreeArray[index] == 0){
                        
                        q1.add(index);
                    }
                }
            }
            
        }
      //   System.out.println("map is " + map1);
       //  System.out.println("queue is" + q1);
        
        //check if all indegrees have become 0
    for(int i = 0; i < indegreeArray.length; i ++){
            
      //   System.out.println("indegree of i is" + indegreeArray[i]);
            if(indegreeArray[i] != 0){
                
                return false;
            }
        }
   // System.out.println(map1);
        
     return true;
    }
}
