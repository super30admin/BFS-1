// Time Complexity : O(prerequisites.length)+o(no.of courses)
// Space Complexity : O(no.of courses)
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach/**
buidl an indegree array along with the map with independent courses as key and their dependents as list of values
pushed into the queue when the subject becomes independent and decrement their dependent subjectes indegree value
when queue becomes empty but still indegree array has non zero values then retur false. else return true



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        
        int [] indegree = new int[numCourses];
        HashMap<Integer,List<Integer>>map = new HashMap<>();
        for(int i = 0;i<prerequisites.length;i++)
        {
            indegree[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])) 
                map.put(prerequisites[i][1],new ArrayList<>());
                  
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }    
       for(int i=0;i<numCourses;i++){
             System.out.println(indegree[i]);
        }
        
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            List<Integer>li = map.get(temp);
            
            if(li!=null){
                for(int i=0;i<li.size();i++){
                indegree[li.get(i)]--;
                if(indegree[li.get(i)]==0) q.add(li.get(i));
                }
                li.clear();
            }
            
        }
        for(int i=0;i<numCourses;i++){
             System.out.println(indegree[i]);
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]!=0){
                return false;
            }
        }
        return true;
    }
}
