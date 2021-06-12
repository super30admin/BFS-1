/*Running Time Complexity: O(VxE)
Space Complexity: O(n)
Successfullly run and Compiled on leetcode.
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        //putting all courses into the hashmap and increasing the indegree for each vertex
        for (int [] edges: prerequisites){
            int in = edges[0];
            int out = edges[1];
            if (!hmap.containsKey(out)){
                hmap.put(out,new ArrayList<>());
            }
            hmap.get(out).add(in);
            inDegrees[in]++;
        }   
        
        //Putting all course with 0 dependency into queue
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<inDegrees.length;i++){
            if (inDegrees[i] == 0){
                q.add(i);
            }
        }
        
        //reducing the dependcies of vertex
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(hmap.get(curr)==null) continue;
            for(int c: hmap.get(curr)){
                inDegrees[c]--;
                if (inDegrees[c]==0){
                    q.add(c);
                }
            }
        }
        //System.out.println(q);
        for (int i=0;i<inDegrees.length;i++){
            if(inDegrees[i]>0) return false;
        }
        return true;
           
    }
}