// Time Complexity : O(V + E) where V is the vertices and E is the edges 
// Space Complexity : O(V + E) where V is the vertices and E is the edges
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0){
            return true;
        }

        int[] inDegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int[] prereq : prerequisites){
            int to = prereq[0];
            int from = prereq[1];
            inDegrees[to]++;

            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }

        for(int i = 0; i < inDegrees.length; i++){
            if(inDegrees[i] == 0){
                count++;
                q.add(i);
            }
        }

        if(q.isEmpty()){
            return false;
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if(edges == null){
                continue;
            }
            for(int edge : edges){
                inDegrees[edge]--;
                if(inDegrees[edge] == 0){
                    count++;
                    q.add(edge);
                }
            }
        }

        return numCourses == count;
    }
}
