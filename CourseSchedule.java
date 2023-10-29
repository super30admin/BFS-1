// we make the adjacency list
// and then when traversing independent nodes, add them to the list 
// array of indegrees
// adjacency list will be hashmap of nodes and who is dependent on the current node, basically it's babies
// BFS Solution
//TC: O(V+E)
//SC: O(V+E)
//Works on leetcode

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for(int[] pr: prerequisites){
            int out = pr[1];
            int in = pr[0];
            indegrees[in]++;

            if(!map.containsKey(out))
            {
                map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }

        int count = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++)
        {
            if(indegrees[i] ==0)
            {
                q.add(i);
                count++;
            }
        }

        if(count == numCourses) return true;

        if(q.isEmpty()) return false;

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> babies = map.get(curr);

            if(babies != null)
            {
                for(int baby: babies)
                {
                    indegrees[baby]--;
                    if(indegrees[baby] == 0)
                    {
                        q.add(baby);
                        count++;
                        if(count == numCourses) return true;
                    }
                }
            }
        }
        return count == numCourses;
    }
}

