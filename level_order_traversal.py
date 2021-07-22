#Time Complexity: O(N).
#Auxiliary Space: O(h)
#Did this code successfully run on Leetcode :Yes



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
        if not root:
            return []
        self.queue = []
        level  = 0
        
        def helper(root,level):
            if not root:
                return
            
            if len(self.queue)==level:
                self.queue.append([root.val])
            else:
                self.queue[level].append(root.val)
            helper(root.left,level+1)
            helper(root.right,level+1)
        
        helper(root,0)
        
        return self.queue