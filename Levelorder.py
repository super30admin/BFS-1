#TC-O(n)
#SC-O(n)
#ran on leetcode-yes
#logic- create a result which is a list of lists and assign every node to the list at the index equal to its level
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        global result
        result = []
        def helper(root,level):
            global result
            if root is None:
                return 
            if level == len(result):
                result.append([])
            result[level].append(root.val)
            helper(root.left,level+1)
            helper(root.right,level+1)
    
        helper(root,0)
        return result
        