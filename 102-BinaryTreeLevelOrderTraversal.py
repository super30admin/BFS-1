# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None: return []
        result = []
        q = []
        q.append(root)
        while q:
            size = len(q)
            li = []
            for i in range(0, size):
                curr = q.pop(0)
                li.append(curr.val)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
            result.append(li)
        return result
    
    
# O(N) => Size of the binary tree
# O(h) => Since we are using queue
# Approach => Take a node appends its left and right child in a stack. Take all the nodes of that level and create a list. The created list should be appended to other list.
# Return all the list
                
        
                         

        
        
        