// Time Complexity : MAX(o(V), o(E))
// Space Complexity :o(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        int count = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int[] arr: prerequisites)
        {
            indegrees[arr[0]]++;
            if(!map.containsKey(arr[1]))
            {
                map.put(arr[1], new ArrayList<>());
            }
            map.get(arr[1]).add(arr[0]);
        }
        for(int i=0; i<indegrees.length; i++)
        {
            if(indegrees[i] == 0)
            {
                q.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int val = q.poll();
            count++;
            List<Integer> ar = map.get(val);
            if (ar != null){
                for(int j: ar)
                {
                    indegrees[j]--;
                    if(indegrees[j] == 0){
                        q.add(j);
                    }
                }
            }
        }
        if(count != numCourses) return false;
        return true;
    }
}