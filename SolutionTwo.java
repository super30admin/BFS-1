
// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : nopes
class SolutionTwo {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegrees=new int[numCourses];


        HashMap<Integer,List<Integer>> map=new HashMap<>();

        //create hashmap with course value as key and outdegree as values
        for(int i=0;i<prerequisites.length;i++)
        {
            indegrees[prerequisites[i][0]]++;

            if(!map.containsKey(prerequisites[i][1]))
            {
                map.put(prerequisites[i][1],new ArrayList());
            }

            map.get(prerequisites[i][1]).add(prerequisites[i][0]);

        }
        Queue<Integer> q=new LinkedList<>();

        //add independent course to queue
        for(int i=0;i<numCourses;i++)
        {
            if(indegrees[i]==0)
            {
                q.add(i);
            }


        }

        while(!q.isEmpty())
        {
            int current = q.poll();
            List<Integer> children = map.get(current);

            if(children!=null)
            {
                for(int child:children)
                {
                    indegrees[child]--;

                    //child has become independent
                    if(indegrees[child]==0)
                    {
                        q.add(child);
                    }
                }
            }

        }

        for(int i=0;i<numCourses;i++)
        {
            if(indegrees[i]>0)
            {
                return false;
            }

        }

        return true;
    }
}