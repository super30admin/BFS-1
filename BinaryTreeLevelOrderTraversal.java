//Solved successfull on leetcode and faced no issues
//Time complexoty : O(n) Space complexity : O(n)


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>output = new ArrayList<>();
        if(root == null){
            return output;
        }
        Queue<TreeNode>queue = new LinkedList<>();
        //Insert element into queue
        queue.add(root);
        //start our bfs
        while(!queue.isEmpty()){
            int queuesize = queue.size();
            List<Integer>currentlevel = new ArrayList<>();
            //we will be performing bfs current queusize times
            while(queuesize>0){
                //remove the element
                TreeNode cnode = queue.remove();
                //do something - in this problem , storing in currentlvl
                currentlevel.add(cnode.val);
                //process its children
                if(cnode.left!=null){
                    queue.add(cnode.left);
                }
                if(cnode.right!=null){
                    queue.add(cnode.right);
                }
                //decrement the queuesize
                queuesize--;
            }
            output.add(currentlevel);
        }
        return output;
        
    }
}