//TC :O(V+E) SC :O(V+E) where V and E are the Vertices and Edges of the graph
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courses = new int[numCourses];
        Map<Integer,List> mp = new HashMap<> ();
        for(int i=0;i<prerequisites.length;i++)
        {
            int[] temp = prerequisites[i];
            courses[temp[0]]++;
            if(mp.get(temp[1])==null)
                mp.put(temp[1],new ArrayList<>());

            mp.get(temp[1]).add(temp[0]);
        }

        int count =0;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(courses[i]==0)
            {
                q.add(i);
            }
        }

        if(q.isEmpty()) return false;

        while(!q.isEmpty())
        {
            int currentCourse = q.poll();
            count++;

            List<Integer> edges = mp.get(currentCourse);
            if(edges!=null){
                for(int n : edges)
                {
                    courses[n]--;
                    if(courses[n] == 0)
                    {
                        q.add(n);
                    }
                }
            }
        }
        System.out.println("Count : "+count);
        System.out.println("numOfCourses : "+numCourses);
        return count == numCourses;
    }
}