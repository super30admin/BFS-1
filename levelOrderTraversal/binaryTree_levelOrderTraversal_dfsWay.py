'''
// Time Complexity : 0(n) -- end up traversing all the nodes
// Space Complexity : 0(h) -- recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.resultList = []
    
    def levelOrderTraversal(self,node,level,resultList):
        # base-case
        if node == None:
            return
        
        # logic-case
        if len(self.resultList) == level:
            # level-index doesnt exist
            self.resultList.append([node.val])
        
        else:
            # level-index exist
            self.resultList[level].append(node.val)
        
        # recursive-call lhs
        self.levelOrderTraversal(node.left,level+1,resultList)
        
        # recursive-call rhs
        self.levelOrderTraversal(node.right,level+1,resultList)
        
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        # recursive call levelOrderTraversal
        self.levelOrderTraversal(root,0,self.resultList)
        
        return self.resultList
        
        
        
        
        