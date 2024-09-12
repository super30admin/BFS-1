// Time Complexity : O(n)
// Space Complexity : O(2^height)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root==null)
            return rest;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty() && q.peek()!=null){
            TreeNode last = null;
            while(q.peek()!=null){
                last = q.poll();
                if(last.left!=null)
                    q.add(last.left);
                if(last.right!=null)
                    q.add(last.right);
            }
            q.poll();
            q.add(null);
            result.add(last.val);
        }
        
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(2^height)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root==null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            TreeNode last = null;
            for(int i=0;i<size;i++){
                last = q.poll();
                if(last.left!=null)
                    q.add(last.left);
                if(last.right!=null)
                    q.add(last.right);
            }
            result.add(last.val);
        }
        
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(height)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        int maxHeight = -1;
        List<Integer> tmpList = new LinkedList<>();
         helper(tmpList, root, 0, maxHeight);
        return tmpList;
    }
    
    public int helper(List<Integer> tmpList, TreeNode root, int height, int maxHeight) {
        if(root==null)
            return maxHeight;
        
        if(maxHeight<height){
            maxHeight=height;
            tmpList.add(root.val);
        }
        
        int rightHeight = helper(tmpList, root.right, height+1,maxHeight);
        int leftHeight = helper(tmpList, root.left, height+1,Math.max(maxHeight,rightHeight));
        
        return Math.max(leftHeight,rightHeight);
    }
}