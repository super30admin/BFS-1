// Time Complexity : O(v+e)  v=no of courses. e=no of edges or dempendencies.
// Space Complexity :O(v+e)   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count=0;
        if(prerequisites==null){return true;}
        LinkedList<Integer> q=new LinkedList<Integer>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        int[] indegrees=new int[numCourses];
        for(int[] temp:prerequisites)
        {
            indegrees[temp[0]]++;
            if(map.containsKey(temp[1]))
            {
                 map.get(temp[1]).add(temp[0]);
            }
            else
            {
                List<Integer> d=new ArrayList<>();
                d.add(temp[0]);
                map.put(temp[1],d);
            }
        }
        for(int i=0;i<indegrees.length;i++)
        {
            if(indegrees[i]==0)
            {
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty()){return false;}
        while(!q.isEmpty())
        {
            int x=q.poll();
            List<Integer> dependents=map.get(x);
            if(dependents!=null)
            {
            for(int dep:dependents)
            {
                indegrees[dep]--;
                if(indegrees[dep]==0)
                {
                    q.add(dep);
                    count++;
                }
            }
            }
        }
        return count==numCourses;
    }
}