# Time complexity:O(n)
# Space complexity: 0(n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int countNodes = queue.size();
            for(int i = 0; i < countNodes; i++){
                TreeNode currentNode = queue.poll();
                if(i == countNodes - 1){
                    result.add(currentNode.val);
                }

                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
        }
        return result;
    }


}