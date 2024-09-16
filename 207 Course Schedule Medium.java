//207 Course Schedule Medium.java
//Time Complexity: O(n^2);
//Space Complexiy: O(n) //infcount and stack
//n is number if courses
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //array which has number of dependets, call it info
        Stack<Integer> toVisit = new Stack<>();
        int count = 0;
        int[] infoCount = new int[numCourses];
        for( int i = 0; i < prerequisites.length; ++i){
            int key = prerequisites[i][0];
            infoCount[key]++;
            
        }

        for( int i = 0; i < numCourses; ++i){

            //check if no dependents
            if(infoCount[i] == 0){
                toVisit.push(i);
            }
        
        }
        
        //process the stack and add if any element does not have depenedents
        while(!toVisit.isEmpty()){
            
            int currentKey = toVisit.peek();
            toVisit.pop();
            infoCount[currentKey] = -1;
            count++;
            
            //go through all the elements if it was in someone's dependent decrease count
            for( int i = 0; i < prerequisites.length; ++i){
                  int key = prerequisites[i][0];
                  if(prerequisites[i][1] == currentKey){
                    infoCount[key]--;
                      //no depenedents
                    if(infoCount[key] == 0) 
                        toVisit.push(key);    
                }
            }
      
        }
        
     return count == numCourses;
       
     }
}