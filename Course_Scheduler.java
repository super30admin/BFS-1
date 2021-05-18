class Solution {
    //Time O(V+E)
    //Space O(NumOfCourses)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)
        {
            return true;
        }
        int inDegrees[] = new int[numCourses];
        for(int[] preq : prerequisites)
        {
            inDegrees[preq[0]]++;
        }
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int[] preq : prerequisites)
        {
            int in = preq[0];
            int out = preq[1];
            if(!map.containsKey(out))
            {
                map.put(out , new ArrayList<>());
            }
            map.get(out).add(in);
        }
        Queue<Integer> Q = new LinkedList<>();
        for(int i=0 ; i<inDegrees.length ; i++)
        {
            if(inDegrees[i] == 0)
            {
                Q.add(i);
            }
        }
        if(Q.isEmpty())
        {
            return false;
        }
        while(!Q.isEmpty())
        {
            int processed = Q.poll();
            if(map.get(processed) == null) continue;
            for(int i : map.get(processed))
            {
                inDegrees[i]--;
                if(inDegrees[i] == 0)
                {
                    Q.add(i);
                }
            }
        }
        for(int i=0 ; i<inDegrees.length ; i++)
        {
            if(inDegrees[i] != 0)
            {
                return false;
            }
        }
        return true;
    }
}