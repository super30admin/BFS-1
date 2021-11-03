//Time: O(n)
//Space: O(n)
//LeetCode: https://leetcode.com/submissions/detail/581227070/
//Approach: Using BFS
using System;
using System.Collections.Generic;

namespace BFS_1
{
    public class Solution {
        public IList<IList<int>> LevelOrder(TreeNode root) {
            
            List<IList<int>> result = new List<IList<int>>();
            if(root == null) {
                return result;
            }
            Queue<TreeNode> q = new Queue<TreeNode>();
            q.Enqueue(root);        
            
            while(q.Count > 0) {
                int size = q.Count;
            
                List<int> currentLevel = new List<int>();
                
                for(int i=0; i < size; i++) {
                    TreeNode outt = q.Dequeue();
                    currentLevel.Add(outt.val);
                    
                    if(outt.left != null){
                        q.Enqueue(outt.left);
                    }
                    if(outt.right != null){
                        q.Enqueue(outt.right);
                    }  
                }
                result.Add(currentLevel);
            }
            return result; 
        }
        public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    }
}
