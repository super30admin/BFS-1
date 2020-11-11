# Time Complexity:- O(n)
# Space Complexity:-O(h) height of the tree
# Approach:- Do a dfs from the root node increasing the height everytime. We want to check the right side view so we do dfs on the right child 
# of every node and increasing height by 1. Everytime we find a root that has increased the height we append to our result array.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.res=[]
        def rsv(root,height):
            if root is None:
                return
            # height has increased than what we knew before this node will be visible if we see the tree from the right
            if height==len(self.res):
                self.res.append(root.val)
            # we want the right side view so we start by checking the right nodes first
            rsv(root.right,height+1)
            rsv(root.left,height+1)
        rsv(root,0)
        return self.res