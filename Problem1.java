// # BFS-1
// # Problem 1
// Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

// Time Complexity : BFS with Queue - O(N)
// Space Complexity : BFS with Queue - O(N/2) max for leaf nodes in worst case ==> O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only


class Solution {
    // 1. Use a queue to do BFS
    // Time: O(N)
    // Space: O(N/2) max for leaf nodes in worst case ==> O(N)
    public List<List<Integer>> bfsHelper(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();

        // Result
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }

        // Add root node
        q.add(root);
        // Size at level n
        int size_n;

        while(!q.isEmpty()){
            size_n=q.size();

            // Process current level
            List<Integer> currLevel= new ArrayList<>();
            for(int i=0;i<size_n;i++){
                TreeNode curr=q.remove();
                
                // Process the current node
                currLevel.add(curr.val);

                // Add children of curr node to queue
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }

            }

            // Add curr level list to result
            result.add(currLevel);
        }

        return result;
    }


    private void dfs(TreeNode root, int level, Map<Integer, List<Integer>> levelMap){
        if(root==null)  return;

        // Process current node
        if(!levelMap.containsKey(level)){
            levelMap.put(level, new ArrayList<>());
        }

        levelMap.get(level).add(root.val);

        dfs(root.left, level+1, levelMap);
        dfs(root.right, level+1, levelMap);
        
    }

    // 2. Maintain a hasmap of levels -> nodes
    // At each call maintain current level as parameter
    // Iterate over the map and store in result
    // Time: O(N)
    // Space: O(H), recursive stack space
    public List<List<Integer>> dfsHelper(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> levelMap=new HashMap<>();

        // dfs using inOrder
        dfs(root, 0, levelMap);

        // Iterate over map from 0 till curr level doesn't exist
        int currLevel=0;
        while(levelMap.containsKey(currLevel)){
            result.add(levelMap.get(currLevel));
            currLevel++;
        }

        return result;
    }

    private void dfsWithList(TreeNode root, int level, List<List<Integer>> result){
        //Base
        if(root==null){
            return;
        }

        //Logic
        while(result.size()<=level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfsWithList(root.left,level+1,result);
        dfsWithList(root.right,level+1,result);

    }

    // 3. Maintain a list of list of nodes, index of first list corresponds to it's level
    // At each call maintain current level as parameter
    // Time: O(N)
    // Space: O(H), recursive stack space
    public List<List<Integer>> dfsWithListHelper(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        // dfs using inOrder
        dfsWithList(root, 0, result);
        return result;
    }

    

    public List<List<Integer>> levelOrder(TreeNode root){
        //1. Using BFS Queue
        //return bfsHelper(root);
        //2. DFS and hashmap
        //return dfsHelper(root);
        //3. DFS with list
        return dfsWithListHelper(root);
    }
}