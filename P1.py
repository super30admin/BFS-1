# BFS-1
# Problem 1
# Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
# TC : O(n)
# SC : O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if root==None:
            return []
        d = defaultdict(list)
        def helper(root, height):
            d[height].append(root.val)
            if root.left!=None:
                helper(root.left, height + 1)
            if root.right!=None:
                # print(root.val, root.right.val)
                helper(root.right, height + 1)
        helper(root, 0)
        res = d.values()
        # print(d, res)
        return d.values()
        
        # previously written
        # levels = []
        # if not root:
        #     return levels
        # def helper(node, level):
        #     try :
        #         levels[level].append(node.val)
        #     except:
        #         levels.append([])
        #         levels[level].append(node.val)
        #     if node.left:
        #         helper(node.left, level+1)
        #     if node.right:
        #         helper(node.right, level+1)
        # helper(root, 0)
        # return levels