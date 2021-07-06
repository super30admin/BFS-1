// Time - O(N), the time to traverse all nodes
// Space - O(N), here at max all the nodes can be on the queue

public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
        
        q.add(root);
        
        while(!q.isEmpty()) {
            List<Integer> level = new LinkedList<Integer>();   
            int i = 0;
            int cnt = q.size();
            while(i<cnt) { 
                TreeNode node = q.poll();  
                level.add(node.val);    
                if(node.left != null) {   
                    q.add(node.left);
                }
                if(node.right != null) {   
                    q.add(node.right);
                }
                i++;
            }   
            list.add(level);
        }
        
        return list;
        
    }
