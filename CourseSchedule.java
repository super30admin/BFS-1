//Time Complexity: O(E+ V)
// Space Complexity: O(E +V) => Since we are preparing adjacency list that includes all vertices and edges
// Leetcode: 207. Course Schedule - Medium
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null || prerequisites.length==0 )
           return true;
        
        int n=prerequisites.length;
        int[] indegreeArr= new int[numCourses];
        int child, parent;
        // this is dependency list
        HashMap<Integer,List<Integer>> adjList=new HashMap<>();
        //[ai,bi]=>parent=bi, child=ai/ in=ai
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            child=prerequisites[i][0];
            parent=prerequisites[i][1];
            indegreeArr[child]++;
            
            if(!adjList.containsKey(parent))
            {
                ArrayList<Integer> arr=new ArrayList<>();
                adjList.put(parent,arr);
            }
            adjList.get(parent).add(child);
            
        }
        int qElementsCount=0;
        
        //Before traversing the tree using bfs, check for independent nodes and add them to the queue
        for(int i=0;i<indegreeArr.length;i++)
        {
            if(indegreeArr[i]==0)
            {
                q.add(i);
                qElementsCount++;
                
            }
        }
        
        // if there are no independent nodes then return false
       if(q.isEmpty())
           return false;
        
        int curr;
        List<Integer> currList;
        
        while(!q.isEmpty())
        {
            curr=q.poll();
             currList= adjList.get(curr);
            if(currList!=null)
            {
                 for(int Currchild: currList)
                {
                    indegreeArr[Currchild]--;
                    if(indegreeArr[Currchild]==0)
                    {
                        q.add(Currchild);
                        qElementsCount++;
                    }

                }
            }
            
           
        }
        
        return numCourses==qElementsCount;
    }
}