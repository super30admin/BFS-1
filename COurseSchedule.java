Time Complexity-O(N*E) N-No of Coursses E-Edges in the graph
Space Complexity-O(N)
Leetcode Submission-Successful

 public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees= new int[numCourses];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<prerequisites.length;i++)
        {
            degrees[prerequisites[i][0]]++;
        }
        
        for(int i=0;i<degrees.length;i++)
        {
            if(degrees[i]==0)
            {
                q.offer(i);
            }
        }
        
        while(!q.isEmpty())
        {
            int course=q.poll();
            for(int i=0;i<prerequisites.length;i++)
            {
             if(prerequisites[i][1]==course)
                {
                    degrees[prerequisites[i][0]]--;
                    if(degrees[prerequisites[i][0]]==0)
                        q.offer(prerequisites[i][0]);
                }
            }
        }
        for(int num:degrees)
        {
            if(num!=0) return false;
        }
        return true;
    }
