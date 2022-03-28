// Time Complexity : O(|V| + |E|)
// Space Complexity : O(|V| + |E|)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        
        HashMap<Integer, List<Integer> > map = new HashMap<>();
        
        for(int[] arr : prerequisites){
            indegree[arr[0]]++; // Calculating and storing indegrees of all the nodes of graph
            if(!map.containsKey(arr[1])){
                map.put(arr[1], new ArrayList<>());
            }
            map.get(arr[1]).add(arr[0]); // Maintaing the hashmap for Independent node to list of dependent nodes
        }
        
        
        Queue<Integer> queue = new LinkedList<Integer>(); // Queue having only those nodes with having indegree = 0
        
        int count = 0;
        for(int n = 0; n < indegree.length; n++){
            if(indegree[n] == 0){
                count++;
                queue.add(n);
            }
        }
        
        if(queue.isEmpty()) return false; // If no node with indegree is 0, return false
        

        while(!queue.isEmpty()){
            int i = queue.poll();
            //Removing node from queue

            List<Integer> list = map.get(i);
            //Fetching the each child of node I
            if(list == null)   continue;
            
            
            
            for(Integer p : list){
                indegree[p]--;//Reduce inDegrees of node i's neighbours/children
                if(indegree[p] == 0){ //If node having indegree = 0, add that node into Queue.
                    queue.add(p);
                    count++;
                    
                    if(count == numCourses) return true; // If count becomes total no. of courses, directly return true
                }
            }
            
        }
        
        if(count < numCourses)  return false;
        
        return true;
    }
}


