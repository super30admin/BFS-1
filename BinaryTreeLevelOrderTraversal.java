// Time Complexity : O(n); since we are visiting all the nodes
// Space Complexity : O(n/2); So asym O(n) because in CBT the last level size nodes would be O(n/2)+1
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/665117800/)
// Any problem you faced while coding this : No
// My Notes : Add the elements in queue, and based on size iterate; once the loop finishes add the result.

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){return result;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            // Create sublis to add nodes in current level
            List<Integer> subList = new ArrayList<>();
            // determine the size of nodes present in level
            int queueSize = queue.size();
            for(int i=0;i<queueSize;i++){
                TreeNode elem = queue.poll();
                subList.add(elem.val);
               //System.out.println(" Elem : "+elem.val);
                if(elem.left != null){
                    queue.add(elem.left);
                }
                if(elem.right!=null){
                    queue.add(elem.right);
                }
            }
            // Add the sublist after the queue is empty
            result.add(subList);
        }
        return result;
    }
}