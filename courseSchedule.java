// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Took some time to figure it out.


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(numCourses==0)
            return false;
        
        if(numCourses==1)
            return true;
        
        int n=prerequisites.length;
        int[] indegree=new int[numCourses];
        HashMap<Integer,List<Integer>> hashMap=new HashMap<>();
        
        /* Added the elements to the hashmap + indegree array */
        for(int i=0;i<n;i++)
        {
            indegree[prerequisites[i][0]]++;
            
            int key=prerequisites[i][1];
            
            if(hashMap.containsKey(key))
                hashMap.get(key).add(prerequisites[i][0]);
            else
            {
                List<Integer> list=new ArrayList<Integer>();
                list.add(prerequisites[i][0]);
                hashMap.put(key,list);
            }
        }
        
        Queue<Integer> queue=new LinkedList<>();
        
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
                queue.add(i);
        }
        
       
        while(!queue.isEmpty())
        {
            int curr=queue.poll();
            if(hashMap.containsKey(curr))
            {
                for( int i : hashMap.get(curr))
                {
                    indegree[i]--;
                    if(indegree[i]==0)
                        queue.add(i);
                }
            }   
        }
        
        
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]!=0)
                return false;
        }
        
        return true;
    }
}