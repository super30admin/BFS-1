# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.result=[]
    def __dfs(self,root,level):
        if not root:
            return
        #if the list belonging to that level is missing
        if len(self.result)==level:
            self.result.append([])
        self.result[level].append(root.val)
        self.__dfs(root.left, level+1)
        self.__dfs(root.right, level+1)
        
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        '''Time Complexity:O(nlogn)
        Space Complexity: O(1)'''
        #Using dfs
        if not root:
            return
        self.__dfs(root,0)
        return self.result
