// Time Complexity : O(n)
// Space Complexity : O(h) -> h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * I am using a BFS approach, to perform the level order traversal.
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            
            List<Integer> currList = new ArrayList<>();
            
            for(int i=0;i<size;i++){
                
                TreeNode node = queue.poll();
                currList.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }

                if(node.right!=null){
                    queue.add(node.right);
                }               
                
            }
            
            result.add(new ArrayList<>(currList));
            
        }
        
        return result;
        
    }
}

//Time Complexity : O(n)
//Space Complexity : O(h) -> h is the height of the tree
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no


//Your code here along with comments explaining your approach
/*
* I am using a BFS approach, to perform the topological sort. I am calculating the inDegree of every vertex.
* Forming an adjacency list of the graph. Adding all the vertices with '0' inDegree to be inside the queue.
* Perform a topological sort, finally checking if all the indegrees of the vertices are '0' if not there is a cycle.
*/




class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;
        
        int[] inDegree = new int[numCourses];
        
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();
        
        for(int[] x: prerequisites){
            int to = x[0];
            int from = x[1];
            
            inDegree[to]++;
            
            if(!hmap.containsKey(from)){
                hmap.put(from,new ArrayList<Integer>());
            }
            
            hmap.get(from).add(to);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0)
                queue.add(i);
        }
        
        while(!queue.isEmpty()){
            int beg = queue.poll();
            
            if(hmap.containsKey(beg)){
                for(int ele:hmap.get(beg)){
                    inDegree[ele]--;
                    if(inDegree[ele]==0)
                        queue.add(ele);
                }
            }
        }
        
        for(int chk:inDegree){
            if(chk!=0)
                return false;
        }
        
        return true;
    }
}