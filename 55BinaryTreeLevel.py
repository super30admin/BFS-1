"""
// Time Complexity :O(n2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NA
//Explanation:
Traverse through whole tree till leaf node.
Maintain the next level node in nextlevelnode

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        # edge case
        if root is None:
            return []

        result = []
        currentlevel = [root]

        while currentlevel != []:
            nodevalues = []
            nextlevelnode = []
            for node in currentlevel:
                nodevalues.append(node.val)
                if node.left:
                    nextlevelnode.append(node.left)
                if node.right:
                    nextlevelnode.append(node.right)
            result.append(nodevalues)
            currentlevel = nextlevelnode
        return result
