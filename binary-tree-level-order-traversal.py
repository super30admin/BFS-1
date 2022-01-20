'''
TC: O(N)
SC: O(N)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        if not root:
            return []
        
        stack = list()
        curr = [root, None]
        temp = list()
        
        while curr:
            top = curr.pop(0)
            if top == None:
                stack.append(temp)
                temp = list()
                if not curr:
                    break
                curr.append(None)
                continue
            temp.append(top.val)
            if top.left:
                curr.append(top.left)
            if top.right:
                curr.append(top.right)
        
        return stack
            