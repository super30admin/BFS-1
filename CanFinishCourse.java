//Time complexity: O(v*e)
//Space complexity: O(v+e)
//Executed on leetcode.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++)
        {
            indegree[prerequisites[i][1]]++;
            if(!map.containsKey(prerequisites[i][0]))
            {
                map.put(prerequisites[i][0],new ArrayList<Integer>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        Queue<Integer> queue = new LinkedList<>();  //Working with indegree and outdegree.
        for(int i=0;i<indegree.length;i++)          //getting the values to indegree array from the second position of the prerequisites.
        {
            if(indegree[i]==0)          //Starting with the element that has no outdegree we traverse through each elements indegree and outdegree.
            {                
                queue.add(i);
            }                           //At the end no element should have indegree elements.
        }
        
        while(!queue.isEmpty())                         
        {
            int s = queue.poll();
            if(map.containsKey(s))
            {
            List<Integer> li = map.get(s);
            for(int j=0;j<li.size();j++)
            {
                if(--indegree[li.get(j)]==0)
                    queue.add(li.get(j));
            }
            }
        }
        
        for(int i:indegree)
        {
            if(i!=0)
                return false;
        }
        
        return true;
    }
}