import java.util.ArrayList;
import java.util.List;
//TC: O(n)
//SC:O(n)
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> bfsResult=new ArrayList<>();
        if(root==null)
            return bfsResult;
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            ArrayList<Integer> subList=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode parent=que.poll();
                subList.add(parent.val);
                if(parent.left!=null)
                    que.add(parent.left);
                if(parent.right!=null)
                    que.add(parent.right);
            }
            bfsResult.add(subList);
        }
        return bfsResult;
    }
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> dfsResult=new ArrayList<>();
        if(root==null)
            return dfsResult;
        dfs(root,0,dfsResult);
        return dfsResult;
    }
    private void dfs(TreeNode root, int level, List<List<Integer>> result){
        if(root==null)
            return;
        if(result.size()==level)
            result.add(new ArrayList<>());
        result.get(level).add(root.val);
        dfs(root.left,level+1,result);
        dfs(root.right,level+1,result);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> dfsResult=new ArrayList<>();
        if(root==null)
            return dfsResult;
        Stack<Object> stk = new Stack<>();
        stk.push(root);
        stk.push(0);
        while(!stk.isEmpty()){
            int level= (int) stk.pop();
            TreeNode curr= (TreeNode) stk.pop();
            if(dfsResult.size()==level)
                dfsResult.add(new ArrayList<>());
            dfsResult.get(level).add(curr.val);
            if(curr.right!=null) {
                stk.push(curr.right);
                stk.push(level + 1);
            }
            if(curr.left!=null) {
                stk.push(curr.left);
                stk.push(level + 1);
            }
        }

        return dfsResult;
    }
}
