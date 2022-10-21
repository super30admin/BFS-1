//1. calculate indegress array by traversing through the courses. 
//course[0] , indegrees[course[0]] ++; so at last dependent course will hold values >0

//2. built adjaceny list - Hashmap by traversing course schedule
//course complete count variable ==0. 
//3. traverse in indegrees and push 0's index to the queue and coursecomplete++. 
//4. BFS on queue<Integer>
//5. map.get(key); key is indegree array's index pushed into queue. 

//tc - O(V+E) = O() - traverse over prerequisite - O(n) + traverse over indegrees O(n) + BFS O(v) ==O(n)
//sc - queue O(V) + edge Hashmap O(E)  = O(V+E)

class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if( prerequisites == null || prerequisites.length == 0)
            return true;
        
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] course : prerequisites)
        {
            int in = course[0];
            int out = course[1];
            //course ==[1,5]
            indegrees[in]++;
            
            if(!map.containsKey(out))
            {
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        
        //traverse the indegrees and build queue. 
        int complete =0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i= 0; i< indegrees.length; i++)
        {
            if(indegrees[i] ==0)
            {
                complete++;
                q.add(i);
            }
        }
        
        //BFS on queue. 
        while(!q.isEmpty())
        {
            //poll
            int in = q.poll();
            
            //fetch list for the completed courses - that list will dependent courses
            List<Integer> edges = new ArrayList<>();
            edges = map.get(in);
            
            if(edges !=  null)
            {
                for(int edge : edges)
                {
                    indegrees[edge]--;

                    if(indegrees[edge] == 0) 
                    {
                        complete++;
                        q.add(edge);
                    }
                }
            }
        }
        return complete == numCourses;
        
    }
}