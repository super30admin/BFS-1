//TC: O(V+E)
//SC: O(V+E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int [] indegrees=new int[numCourses];
        for(int [] edge: prerequisites)
        {
            int in =edge[0];
            int out=edge[1];
            indegrees[in]++;
            if(!map.containsKey(out))
            map.put(out,new ArrayList<>());
            map.get(out).add(in);
        }
        Queue<Integer> q=new LinkedList<>();
        int count=0;
        for(int i=0;i<numCourses;i++)
        {
            if(indegrees[i]==0)
            {
                q.add(i);
                count++;
            }
        }
        if(q.isEmpty())
        return false;
        while(!q.isEmpty())
        {
            int curr=q.poll();
            List<Integer> children=map.get(curr);
            if(children==null)
            continue;
            for(int child:children)
            {
                indegrees[child]--;
                if(indegrees[child]==0)
                {
                    q.add(child);
                    count++;
                    if(count==numCourses)
                    return true;
                }
            }
        }
        if(count==numCourses)
        return true;
        return false;

    }
}