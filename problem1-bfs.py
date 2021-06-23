# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        if root == None: return result
        stack = []
        stack.append(root)
        while stack:
            size = len(stack)
            
            li =[]
            for _ in range(size):
                curr = stack.pop(0)
                li.append(curr.val)
                if curr.left is not None: stack.append(curr.left)
                if curr.right is not None: stack.append(curr.right)
            result.append(li)
            print(li)
        
        return result
    
#Time complexity is O(n) as using lists for stack and removing the first element raises the complexity
#Space complexity is O(n) worst case will have all the child nodes in the stack
#Approach used is storing all the nodes in a level in a list and appending it to the resultant list