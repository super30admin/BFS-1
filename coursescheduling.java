//TC:O(V+E)
//SC:O(V+E)
//Successfully ran on leetcode

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        int[] inDegree=new int[numCourses];
        HashMap<Integer,List<Integer>> adjlist=new HashMap<>();


        //Getting inDegree & adjacency list
        for(int[] x: prerequisites)
        {
            int to=x[1];
            int from=x[0];

            inDegree[to]++;

            if(!adjlist.containsKey(from))
            {
                adjlist.put(from, new ArrayList<>());
            }
            adjlist.get(from).add(to);
        }

        //BFS

        Queue<Integer> queue=new LinkedList<>();
        for(int x=0;x<numCourses;x++)
        {
            if(inDegree[x]==0)
                queue.add(x);
        }

        while(!queue.isEmpty())
        {
            int front=queue.poll();

            if(adjlist.containsKey(front))
            {
                for(int x:adjlist.get(front))
            {
                inDegree[x]--;
                if(inDegree[x]==0)
                {
                    queue.add(x);
                }
            }
            }

        }

        //checking for dependencies

        for(int x:inDegree)
        {
            if(x!=0)
            {
                return false;
            }
        }

        return true;
    }
}
