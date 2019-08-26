# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        # Time Complexity : O(n) where n is the number of nodes in the tree
        # Accpeted on Leetcode
        if root == None:
            return None
        q = []
        q.append(root) # queue to store the elements visited in the tree in every level
        res = []
        while len(q) > 0:
            temp = [] # to store all the elements in a particular level
            tempq = [] # to store the nodes that are present in the next level
            for i in q:
                temp.append(i.val)
                if i.left != None:
                    tempq.append(i.left)
                if i.right != None:
                    tempq.append(i.right)
            res.append(temp[-1]) # Append the values of particular level to the result
            q = tempq # Assign the nodes that are present in the next level so that we can iterate over them
        return res