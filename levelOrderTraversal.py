"""
https://leetcode.com/problems/binary-tree-level-order-traversal/
TC - O(n)
SC - O(h)
Approach using BFS--
1. Since we need to do a level order traversal, we use queue DS
2. Create a rtnData list and a li list to append lists (li) to list (rtnData)
3. Add root to queue. Not root.val, since we need access to left adn right nodes
4. While queue is not empty, assign the curr root to a variable (for eg, node). Pop it now.
5. Append the curr root.val to li
5. Check if node.left and node.right exists. if yes, add them to queue.6. repeat the process
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # BFSbasd approach
        if root is None: return

        rtnData = []

        sQueue = []

        sQueue.append(root)

        while len(sQueue) > 0:
            size = len(sQueue)
            li = []

            for i in range(size):
                curr = sQueue.pop(0)
                li.append(curr.val)

                if curr.left is not None:
                    sQueue.append(curr.left)

                if curr.right is not None:
                    sQueue.append(curr.right)

            rtnData.append(li)

        return rtnData

        # using recursive stack space
        # dfs based solution
        # TC - O(n)
        # SC - O(h) - since recursive stack
        # we use preorder here
        # inorder or postorder won't work since we are making recursive call before we get the ele
#         result = []
#         if root is None: return result

#         dfs(root, 0)

#         return result

#     def dfs(self, root: Optional[TreeNode], lvl) -> List[List[int]]:
#         # base

#         # logic
#         if len(result) == lvl:
#             result.add()

#         result.


#         output = []
#         if not root:
#             return output

#         def helper(node, level):
#             #if all levels are covered
#             if len(output) == level:
#                 output.append([])

#             #append nodes at current level
#             output[level].append(node.val)

#             #process child nodes
#             if node.left:
#                 helper(node.left, level + 1)

#             if node.right:
#                 helper(node.right, level + 1)

#         #call helper
#         helper(root, 0)
#         return output
