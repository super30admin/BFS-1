//time complexity:O(V+E)(V:no of courses and E: no of edges)
//space complexity:O(V+E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null||prerequisites.length==0) return true;
        int[] indegrees=new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] prerequisite: prerequisites)
        {
            int in=prerequisite[0];
            int out=prerequisite[1];
            indegrees[in]++;//fill the indegrees array
            //with the no of dependency corresponding to the index
            if(!map.containsKey(out))
            {
                map.put(out, new ArrayList<>());//if there is no independent 
                //course in the map then add it and create an arraylist as value
                
            }
            map.get(out).add(in);//add key : independent and value:dependent courses
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegrees.length;i++)
        {
            if(indegrees[i]==0)
            {
                q.add(i);//iterate over indegrees array and find the 
                //independent courses and add it to the queue
            }
        }
        int count=0;
        while(!q.isEmpty())
        {
            int curr=q.poll();
            count++;
            List<Integer> edges=map.get(curr);//add the value corresponding to the
            //curr(independent course) in edges
            if(edges!=null)
            {
                for(int edge:edges)
                {
                    indegrees[edge]--;//reduce the dependency by 1
                    if(indegrees[edge]==0)
                    {
                        q.add(edge);//if there is no dependency then add the 
                        //course in the queue
                    }
                }
            }
        }
        if(count!=numCourses) return false;
        return true;
    }
}
