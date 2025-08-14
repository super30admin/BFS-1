 /*DFS approach
1. Keep track of level for each node while traversing the tree using dfs
2. create a new list everytime if the result list size is equal to the level
3. add the node to level index in list
 */

//Time: O(n)
//Space: O(h)
class Solution {

    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {

        this.res=new ArrayList<>();
        dfs(root,0);
        return res;

    }

    private void dfs(TreeNode root, int level){

        if(root==null) return;

        if(level==res.size()){ //it means result list does not have any sublist at level index
            res.add(new ArrayList<>()); //create a list
        }
        res.get(level).add(root.val); //access the list for level index and add the node for that level
        dfs(root.left, level+1);
        dfs(root.right, level+1);

    }
}


/*BFS approach*/
//Time: O(n)
//Space: O(n/2) = O(n) -- max no of nodes in queue at a particular level
 class Solution {

     public List<List<Integer>> levelOrder(TreeNode root) {
         if(root==null)
             return new ArrayList<>();
         Queue<TreeNode> queue= new LinkedList<TreeNode>();
         List<List<Integer>> res = new ArrayList<>();

         queue.add(root);
         int count=0;
         TreeNode curr;
         List<Integer> temp;

         while(!queue.isEmpty()){

             count=queue.size();

             temp=new ArrayList<Integer>();

             for(int i=0;i<count;i++){
                 curr=queue.poll();
                 temp.add(curr.val);

                 if(curr.left!=null)
                     queue.add(curr.left);

                 if(curr.right!=null)
                     queue.add(curr.right);
             }
             res.add(temp);
         }

         return res;
     }
 }