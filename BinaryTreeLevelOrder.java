//Time Complexity=O(n)
//Space Complexity=O(n)
public class BinaryTreeLevelOrder {

        if(root==null){
        return result;
    }
    Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
    int size;

        while(!q.isEmpty()){
        size=q.size();
        List<Integer> li=new ArrayList();
        for(int i=0;i<size;i++){
            TreeNode temp=q.poll();
            li.add(temp.val);
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        result.add(li);

    }
        return result;
}
