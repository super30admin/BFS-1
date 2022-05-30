#Time Complexity: O(N)
#Space Complexity: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        result = []
        queue = [root]
        li = []
        if root == None:
            return None
        
        while queue:
            size = len(queue)
            li = []
            for i in range(0,size):
                node = queue.pop(0)
                li.append(node.val)
                if node.left!=None:
                    queue.append(node.left)
                if node.right!=None:
                    queue.append(node.right)
                    
            result.append(li)
            
        return result


#Recursion
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return None
        self.result = [[]]
        self.helper(root,0)
        return self.result
        
        
    def helper(self,root,level):
        if not root:
            return None

        if len(self.result) == level:
             self.result.append([])
        self.result[level].append(root.val)
        
        self.helper(root.left,level + 1)
        self.helper(root.right,level + 1) 