// Time Complexity : O(n * 2) => O(n)
// Space Complexity : O(n * 2) => O(n)
// Method used : BFS

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(prerequisites == null || prerequisites.length == 0) return true;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap();
        int[] inDegree = new int[numCourses];
        int first, second;
        int courseCount = 0;
        
        for(int i = 0; i < prerequisites.length; i++)
        {
            first = prerequisites[i][1];
            second = prerequisites[i][0];
            ++inDegree[second];
            
            if(!map.containsKey(first))
                map.put(first, new ArrayList());
            map.get(first).add(second);
        }
        
        Queue<Integer> queue = new LinkedList();
        
        for(int i = 0; i < inDegree.length; i++)
        {
            if(inDegree[i] == 0)// Topological sort
            {
                queue.add(i);
                ++courseCount;
            }
        }
        
        while(!queue.isEmpty())
        {
            first = queue.poll();
            if(map.containsKey(first))
            {
               for(int x : map.get(first))
                {
                    --inDegree[x];
                    if(inDegree[x] == 0)
                    {
                        queue.add(x);
                        ++courseCount;
                    }
                } 
            }
        }
        
        return courseCount == numCourses;
        
    }
}