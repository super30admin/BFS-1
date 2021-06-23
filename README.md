# BFS-1
# Problem 1
Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

# Time Complexity : O(n)
# Space Complexity : O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        result = new ArrayList<>(); 
        if(root == null) return result;
        dfs(root,0); 
        return result; 
    }
    
    private void dfs(TreeNode root, int level){
        if(root == null) return; 
    
        if(result.size() == level){ //add new arraylist if result.size is equal to curr root level
            result.add(new ArrayList<>()); 
        }
        
        dfs(root.left, level+1); //go left and increase the level 
        dfs(root.right, level+1); //go right and increase the level

        result.get(level).add(root.val); //add elements to that level 
    }
}

# Problem 2

# Time Complexity : O(V+E)
# Space Complexity : O(V+E)

Course Schedule (https://leetcode.com/problems/course-schedule/)

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(prerequisites == null || prerequisites.length == 0) return true;
        
        int[] indegree = new int[numCourses]; //topological sort 
        
        HashMap<Integer, List<Integer>> myMap = new HashMap<>(); //hashmap for indegree and out degree
        
        for(int[] prerequisite : prerequisites){
            
            int in = prerequisite[0]; //indegree
            int out = prerequisite[1]; //outdegree
            
            indegree[in]++; 
            
            if(!myMap.containsKey(out)){
                myMap.put(out, new ArrayList<>());
            }
             myMap.get(out).add(in);    
        }
        
        Queue<Integer> queue = new LinkedList<>(); //bfs
        
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        int count = 0;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;
            List<Integer> li = myMap.get(curr); 
            
            if(li != null){
            for(int l : li){
                indegree[l]--;
                if(indegree[l] == 0){
                    queue.add(l); 
                }
             }
        }
        }
        
        if(count != numCourses) return false;
        return true; 
    }
}
