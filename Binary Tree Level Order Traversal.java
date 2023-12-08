// Time Complexity :O(N)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
            /**
            * Definition for a binary tree node.
            * public class TreeNode {
            *     int val;
            *     TreeNode left;
            *     TreeNode right;
            *     TreeNode() {}
            *     TreeNode(int val) { this.val = val; }
            *     TreeNode(int val, TreeNode left, TreeNode right) {
            *         this.val = val;
            *         this.left = left;
            *         this.right = right;
            *     }
            * }
            */
            class Solution {
                public List<List<Integer>> levelOrder(TreeNode root) {
                    //BFS
                    List<List<Integer>> result= new ArrayList<>();
                    if(root==null)
                    return result;
                    Queue<TreeNode> q= new LinkedList<>();
                    q.add(root);
                    while(!q.isEmpty())
                    {
                        int size = q.size();
                        List<Integer> list = new ArrayList<>();
                        for(int i=0; i<size;i++)
                        {
                            TreeNode node= q.poll();
                            list.add(node.val);
                        if(node.left!= null)
                            q.add(node.left);

                        if(node.right!= null)
                            q.add(node.right);
                        
                        
                        }
                        result.add(list);

                    }
                    return result;

                //DFS
                //     List<List<Integer>> res= new ArrayList<>();
                //      helper(root,res,0);
                //      return res;
                // }

                // public void helper(TreeNode root,List<List<Integer>> result,int size)
                // {
                //     if(root == null)
                //     return;

                //     if(size== result.size())
                //     result.add(new ArrayList<>());
                //     result.get(size).add(root.val); 

                //     helper(root.left,result,size+1);
                //     helper(root.right,result,size+1);

                }
            }