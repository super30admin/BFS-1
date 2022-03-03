//time complexity: O(log V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //if no prereqs then return true
        if(prerequisites.length == 0){
            return true;
        }
        
        //initialize indegree
        HashMap<Integer, Integer> indegree = new HashMap<>();
        
        //initialize Adjacency List
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        

        //create indegree and adjacency list
        for (int[] innerArray : prerequisites)
        {
            indegree.put(innerArray[0], (indegree.getOrDefault(innerArray[0],0)+1));
            if(!indegree.containsKey(innerArray[1]))
                indegree.put(innerArray[1], 0);
            
            if(!adj.containsKey(innerArray[1])) {
                List<Integer> list = new ArrayList<>();
                list.add(innerArray[0]);
                adj.put(innerArray[1], list);
            } else {
                adj.get(innerArray[1]).add(innerArray[0]);
            }
        }

        //maintain a queue to process nodes
        Queue<Integer> q = new LinkedList<>();

        //count keeps record of classes that can be taken
        int count = 0;
        
        //add nodes with indegree 0 to queue
        indegree.forEach((key,val) -> {
            if(val == 0) {
                q.add(key);
            }
        });
        
        //process nodes 
        while(!q.isEmpty()) {
            int n = q.remove();
            
            count++;
            if(adj.containsKey(n)) {
                //fetch adjacency list for node n
                List<Integer> list = adj.get(n);
                Integer[] V = new Integer[list.size()];
                list.toArray(V);

                //reduce indegree of each node in list by 1
                for(int i=0; i<V.length;i++){
                    indegree.put(V[i], (indegree.get(V[i])-1));
                    
                    //if indegree becomes 0 add it to queue
                    if(indegree.get(V[i]) == 0) {
                        q.add(V[i]);
                    }
                }
            }
        }

        //if indegree of all nodes become 0 return true
        if(indegree.size() == count)
            return true;
        
        //if no node has 0 indegree then false
        //if count < num of courses then false
        if(count == 0 || count<numCourses)
            return false;

        return true;
    }
}