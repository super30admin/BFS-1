//Time Complexity-O(V+E)
//Space complexity-O(V+E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[]numberOfVertices=new int[numCourses];
        HashMap<Integer,List<Integer>>map=new HashMap();
        for(int[]edges:prerequisites)
        {
            int first=edges[0];
            int second=edges[1];
            for(int i=0;i<numberOfVertices.length;i++)
            {
                numberOfVertices[first]+=1;
                if(!map.containsKey(second))
                {
                    map.put(second,new ArrayList());
                }
                map.get(second).add(first);
            }
        }
        Queue<Integer>queue=new LinkedList();
        for(int i=0;i<numberOfVertices.length;i++)
        {
            if(numberOfVertices[i]==0)
            {
                queue.add(i);
            }
        }
        if(queue.isEmpty())
        {
            return false;
        }
        while(!queue.isEmpty())
        {
            int element=queue.poll();
            if(map.containsKey(element))
            {
                List<Integer>childList=new ArrayList(map.get(element));
                for(int child:childList)
                {
                    numberOfVertices[child]--;
                    if(numberOfVertices[child]==0)
                    {
                        queue.add(child);
                    }
                }
            }
        }
        for(int i:numberOfVertices)
        {
            if(i!=0)
            {
                return false;
            }
        }
        return true;
    }
}