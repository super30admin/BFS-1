// Time Complexity : O(v+e)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// take a hashmap to store the dependency list of each node
// take an array to show how many nodes are dependent on you?
// take a queue to store the node that is not having any dependency on other and recude its dependecy basedon the list from map.
// if the count is same as num of courase retun true
// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap< Integer, List<Integer>> hm = new HashMap<>();
        int [] items = new int[numCourses];
        for( int [] elm : prerequisites){
            items[elm[0]]++;
            if(!hm.containsKey(elm[1])){
                hm.put(elm[1], new ArrayList<>());
            }
            hm.get(elm[1]).add(elm[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for( int i = 0; i< numCourses; i++){
            if( items[i] == 0){
                q.add(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            List<Integer> dependOn =hm.get(q.poll());
            if(dependOn != null){
                for(int x : dependOn){
                    items[x]--;
                    if(items[x] == 0){
                        q.add(x); count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}