// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size=queue.size();
            int i=0;
            List<Integer> currList=new ArrayList<>();
            while(i<size){
                TreeNode node=queue.poll();
                currList.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                i++;
            }
            result.add(currList);
        }
        
     return result;   
    }