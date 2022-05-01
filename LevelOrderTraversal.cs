using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
    public class LevelOrderTraversal
    {
        /*
         *  T.C: O(N) since traversing all elements of tree
         *  S.C: O(h) height of tree
         */
        List<IList<int>> result = new List<IList<int>>();
        public IList<IList<int>> LevelOrder(TreeNode root)
        {

            dfs(root, 0);
            return result;
        }

        private void dfs(TreeNode root, int level)
        {
            if (root == null)
                return;

            if (result.Count == level)
            {
                result.Add(new List<int>());
            }

            result[level].Add(root.val);

            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }



        /*
         * T.C: O(N) traversing through all the elements of tree
         * S.C: O(N) actual space is n/2  but asymptotically N
         */
        public IList<IList<int>> LevelOrderBFS(TreeNode root)
        {
            List<IList<int>> result = new List<IList<int>>();

            Queue<TreeNode> queue = new Queue<TreeNode>();

           

            queue.Enqueue(root);

            while(queue.Count>0)
            {
                int size = queue.Count;
                List<int> lst = new List<int>();
                for (int i = 0; i < size; i++)
                {
                    var element = queue.Dequeue();

                    if(element.left!=null)
                    queue.Enqueue(element.left);

                    if(element.right!=null)
                    queue.Enqueue(element.right);
                   
                    lst.Add(element.val);
                   
                }

                result.Add(lst);
            }

            return result;
        }
    }
