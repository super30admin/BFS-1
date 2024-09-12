# Time Complexity : O(N) where N is number of nodes
#Space Complexity : O(B) maximum breadth 

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []
        if root == None:
            return result
        Queue = []
        Queue.append(root)
        while(len(Queue)!=0):
            size = len(Queue)
            temp = []
            for i in range(size):
                curr = Queue.pop(0)
                temp.append(curr.val)
                if curr.left !=None :
                    Queue.append(curr.left)
                if curr.right !=None :
                    Queue.append(curr.right)
                
            result.append(temp)
        return result
        
============================================================================
# Time Complexity : O(N) where N is number of nodes
#Space Complexity : O(H) Height of the Tree 
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []
        
        if root == None:
            return result
        
        def dfs(root,level):
            if root == None:
                return result
            if len(result) == level:
                s = []
                result.append(s)
            result[level].append(root.val)
            dfs(root.left,level+1)
            dfs(root.right,level+1)
       
        dfs(root,0)
        return result