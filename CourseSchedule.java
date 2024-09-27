// inderee Array ==> for no of dependencies
// Hashmap ==> children of each course
// Queue


// Time Complexity: O(V+E)

// Space Complexity: O(V+E)


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //inDegrees array having no of dependencies
        int[] inDegrees = new int[numCourses];
        //hashmap for tracking children
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        
        
        for(int i=0; i<prerequisites.length; i++)
        {
            inDegrees[prerequisites[i][0]]++;
            
            if(!hm.containsKey(prerequisites[i][1]))
            {
                 hm.put(prerequisites[i][1], new ArrayList<>());
            }
            hm.get(prerequisites[i][1]).add(prerequisites[i][0]);
           
        }
        
        //now check if any node has dependencies as zero then add it to the queue
        Queue<Integer> q = new LinkedList<>();
        for(int k=0; k<inDegrees.length; k++)
        {
            if(inDegrees[k]==0)
                q.add(k);
        }
        
        //Starting of the BFS
        while(!q.isEmpty())
        {
            int course = q.poll();
            List<Integer> children = hm.get(course);
            if(children != null)
            {
                for(int child : children)
                {
                    inDegrees[child]--;
                    if(inDegrees[child]==0) q.add(child);
                }
            }
            
        }
        
        for(int j=0; j<inDegrees.length; j++)
            if(inDegrees[j]>0)
                return false;
        
        return true;
    }
}
