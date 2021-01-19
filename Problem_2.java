// Time Complexity :O(V+E)
// Space Complexity :O(V+E)
// Did this code successfully run on Leetcode :Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//Below is the brute force solution.


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] arr=new int[numCourses];
        HashMap<Integer,List<Integer>> hash=new HashMap<Integer,List<Integer>>();
        for(int[] edges:prerequisites){
            arr[edges[0]]=arr[edges[0]]+1;
            if(!hash.containsKey(edges[1])){
                hash.put(edges[1],new ArrayList<Integer>());
            }
            hash.get(edges[1]).add(edges[0]);
        }
        Queue<Integer> qu=new LinkedList<Integer>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                qu.add(i);
            }
        }
        //System
        if(qu.isEmpty()) return false;
        int count=0;
        while(!qu.isEmpty()){
            int vert=qu.remove();
            List<Integer> list=hash.get(vert);
            if(list!=null){
                for(int node :list){
                    arr[node]=arr[node]-1;
                    if(arr[node]==0){
                        qu.add(node);
                    }
                 }
            }
            count=count+1;
        }
        // System.out.println(hash);
        // System.out.println(Arrays.toString(arr));
        if(count==numCourses) return true;
        return false;
        
    }
}