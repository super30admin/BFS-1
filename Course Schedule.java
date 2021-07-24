class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer,List<Integer>> adjlist = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] pair : prerequisites)
        {
            int in = pair[0];
            int out = pair[1];

            if(!adjlist.containsKey(out)) adjlist.put(out,new ArrayList<>());
            adjlist.get(out).add(in);

            indegree[in]++;
        }

        //queue for independent courses

        Queue<Integer> q = new LinkedList<>();
        int complete = 0;

        for(int i=0 ; i<indegree.length ; i++)
        {
            if(indegree[i] == 0) q.add(i);
        }

        if(q.size() == 0) return false;
        if(q.size() == numCourses) return true;

        while(!q.isEmpty())
        {
            int prereq = q.poll();
            List<Integer> courses = adjlist.get(prereq);
            ++complete;

            if(courses!=null)
            {
                for(int course : courses)
                {
                    indegree[course]--;
                    if(indegree[course] == 0) q.add(course);
                }
            }
        }

        return complete==numCourses;
    }
}
