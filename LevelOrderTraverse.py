# Time Complexity : O(N) 
# Space Complexity :    O(N)
# Did this code successfully run on Leetcode : NO - Code editor locked
# Any problem you faced while coding this : NO


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root==None:
            return None
        queue = []
        queue.append(root)
        result = []
        curlist = []
        while(len(queue)!=0):
            cursize = len(queue)
            for i in range(cursize):
                node = queue.pop(0)
                curlist.append(node.val)
                if node.left!=None :
                    queue.append(node.left)
                if node.right!=None :
                    queue.append(node.right)
            result.append(curlist)
            curlist = []
        return result
                
        
        