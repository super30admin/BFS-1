//Course-schedule using BFS
//TC-O(V+E)
//SC-(V+E)

import java.util.*;

class Solution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //we need this array to maintain indegrees of nodes
        //when indegree becomes 0, node gets independent 
        //we push independent nodes to the queue
        int[] indegrees=new int[numCourses];
        //mapping from independent to dependent nodes
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] pr:prerequisites)
        {
            //pr[0](in dependent node ->course)
            //pr[1](out independent node->preq)
            indegrees[pr[0]]++;

            //map doesnt contain independent node/preq
            if(!map.containsKey(pr[1]))
            {
                map.put(pr[1],new ArrayList<Integer>());
            }
            //add depenedent node to list
            map.get(pr[1]).add(pr[0]);
        }
        //push all independent nodes to q first
        Queue<Integer> q=new LinkedList<>();
        //count no of courses added to queue to verify at last
        int count=0;
        for(int j=0;j<indegrees.length;j++)
        {
            if(indegrees[j]==0)
            {
                q.add(j);
                count++;
            }
        }
        if(q.isEmpty()) return false;

        while(!q.isEmpty())
        {
            int indp=q.poll();
            //get dependent nodes of indp
            List<Integer> childern=map.get(indp);
            if(childern!=null)
            {
                for(Integer child:childern)
                {
                    //reduce indegree of child before pushing to queue
                    indegrees[child]--;
                    //repeat same steps
                    if(indegrees[child]==0)
                    {
                        q.add(child);
                        count++;
                    }
                }
            }
            //at any point count becomes equal to no of courses we should take

            if(count==numCourses) return true;
        }
        return false;
    }
}