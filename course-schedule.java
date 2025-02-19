// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only:First, an array is initialized to track the number of dependencies for each item. A mapping is then created, associating independent items with their dependent items using a data structure like a HashMap.  

// Next, all items with zero dependencies are identified and added to a queue, as they can be processed immediately. For each item removed from the queue, its dependent items are retrieved, and their dependency count is decremented, signifying progress. If any dependent item's count reaches zero, it is added to the queue for processing in the next iteration. This process continues until all items are processed.
 


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)return true;
        HashMap<Integer,List<Integer>> sMap=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        int pl=prerequisites.length;
        int[] depArray=new int[numCourses];
        int count=0;
        for(int i=0;i<pl;i++){ // O(n)
            int ind=prerequisites[i][1];
            int dep=prerequisites[i][0];
            depArray[dep]++;
            if(!sMap.containsKey(ind)){
                sMap.put(ind,new ArrayList<>());
            }
            sMap.get(ind).add(dep);
        }
        for(int i=0;i<depArray.length;i++){ //O(m)
              if(depArray[i] == 0){
                q.add(i);
                 count++;
            }
        }
    if(count == numCourses) return true;
          if(q.isEmpty())return false;
           while(!q.isEmpty()){ //O(m)
              int curr=q.poll();
                   List<Integer> courseLi= sMap.get(curr);
                   if(courseLi == null) continue;
                for(int depCour:courseLi){
                   depArray[depCour]--;
                    if(depArray[depCour] == 0){
                q.add(depCour);
                 count++;
                 if(count == numCourses) return true;
           
                  }
                }
                
           }

           return false;
        
    }
}