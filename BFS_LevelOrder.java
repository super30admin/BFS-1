/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//TC = O(N)
//SC = O(N)
class Solution {
  
    public List<List<Integer>> levelOrder(TreeNode root) {
         
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            
                for(int i=0; i< size; i++)
                {  TreeNode temp = q.remove();
                     list.add(temp.val);
                    if(temp.left!=null)
                        q.offer(temp.left);
                    if(temp.right!=null)
                        q.offer(temp.right);
                }
            result.add(list);
        }
        return result;
            }
        }
        
