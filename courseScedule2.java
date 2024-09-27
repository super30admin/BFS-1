class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees=new int[numCourses];
        List<Integer> result=new ArrayList<>();
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<prerequisites.length;i++)
        {
            indegrees[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1]))
            {
                map.put(prerequisites[i][1],new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegrees.length;i++)
        {
            if(indegrees[i]==0)
            {
                q.add(i);
                result.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int temp=q.poll();
            List<Integer> list=map.get(temp);
            if(list!=null)
            {
                for(int data: list)
                {
                    indegrees[data]--;
                    if(indegrees[data]==0)
                    {
                        q.add(data);
                        result.add(data);
                    }
                }
            }
        }
        int[] ans=new int[result.size()];
        for(int i=0;i<indegrees.length;i++)
        {
            if(indegrees[i]>0)
                return new int[0];
        }
        
        for(int i=0;i<result.size();i++)
        {
            ans[i]=result.get(i);
        }
        return ans;
    }
}

// Time Complexity: O(n), n= number of courses
// Space Complexity: O(n)