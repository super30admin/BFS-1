// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root==null){
            return list;
        }

        //level order - use queue
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){

            int levelNum = q.size();

            List<Integer> subList = new ArrayList<Integer>();

            //traversing through the size of the queue
            for(int i=0;i<levelNum;i++){
                if(q.peek().left != null)
                    q.offer(q.peek().left);
                if(q.peek().right!=null)
                    q.offer(q.peek().right);
                subList.add(q.poll().val);
            }

            list.add(subList);
        }

        return list;
    }
}