# Time Complexity - O(n)
# Space Complexity - O(n)
# Using BFS


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
        q = []
        result = []
        q.append(root)
        

        while q:
            curr_level = []
            level_size = len(q)

            for i in range(level_size): 
                curr = q.pop(0)
                curr_level.append(curr.val)
                
                if curr.left : 
                    q.append(curr.left)
                if curr.right : 
                    q.append(curr.right) 
            
        
            result.append(curr_level)
        return result



# Usinf DFS
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.result = []
        self.helper(root,0)
        return self.result

    def helper(self,root,level):
        if not root : 
            return
        if len(self.result) == level:
            self.result.append([])
        self.result[level].append(root.val)
        self.helper(root.left,level+1)
        self.helper(root.right,level+1)

        


