//done using dfs
//Time - O(E+V)
//Space - O(V)
//run in leet code - yes

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length==0) return true;
        int[] inorder = new int[numCourses];
        Queue<Integer> q = new LinkedList<>(); 
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edges : prerequisites){
            inorder[edges[0]] ++;
            if(!map.containsKey(edges[1])){
                map.put(edges[1], new ArrayList<>());
            }
            map.get(edges[1]).add(edges[0]);
        }
        int count =0;
        for(int i=0; i< inorder.length; i++){
            if(inorder[i]==0) {
                q.add(i);
                count++;
                }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if(edges!=null){
                for(int edge: edges){
                    inorder[edge]--;
                    if(inorder[edge] == 0){
                        q.add(edge); count++;
                        if(count==numCourses) return true;
                    }
                }
            }
        }
        return false;
    }
}