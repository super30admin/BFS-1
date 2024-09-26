/**
// Time Complexity : O(n)
// Space Complexity : O(n) size of recursive stack.
                      O(n) size of seen hashmap.
                      O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> seen = new HashMap<>();

        //add nodes to graph.
        for(int node[] : prerequisites){
            List<Integer>alist = graph.getOrDefault(node[1], null);
            if(alist == null){
                alist = new ArrayList<>();
                graph.put(node[1], alist);
            }
            alist.add(node[0]);
            seen.put(node[0], 0);
            seen.put(node[1], 0);
        }

        //find dl.
        for(int parent: graph.keySet()){
            if(seen.get(parent) == 0 && isDL(parent, graph, seen)){
                return false;
            }
        }

        return true;
    }

    //recursive function to find deadlock.
    private boolean isDL(int parent, HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> seen){
        if(seen.get(parent) == 1) //if child node being walked , dl exists
            return true;
        if(seen.get(parent) == 2)//if child node alread walked, no dl
            return false;

        seen.put(parent, 1); // add node as being walked
        List<Integer> alist = graph.getOrDefault(parent, null);
        if(alist != null){
            for(int child: alist){
                if(isDL(child, graph, seen))
                    return true;
            }
        }
        seen.put(parent, 2);// add node as done walking
        return false;
    }
}
