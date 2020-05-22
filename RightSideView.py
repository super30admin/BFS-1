# Time Complexity : O(N)
# Space Complexity : O(B) maximum Breadth N/2

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []
        if root == None:
            return result
        Queue = []
        Queue.append(root)
        while(len(Queue)>0):
            size = len(Queue)
            last = -1
            for i in range(size):
                curr = Queue.pop(0)
                last = curr.val
                if curr.left!=None:
                    Queue.append(curr.left)
                if curr.right!=None:
                    Queue.append(curr.right)
            result.append(last)
        return result
==========================================================
# Time Complexity : O(N)
# Space Complexity : O(H) Height of the Tree

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        def dfs(root,level):
            if root == None:
                return None
            if level == len(result):
                result.append(root.val)
            
            dfs(root.right,level+1)
            dfs(root.left,level+1)
        
        result = []
        
        
        dfs(root,0)
        return result