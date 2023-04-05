# Time Complexity :  O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

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
        while(len(q) > 0):
            size = len(q)
            temp = []
            for i in range(size):
                node = q.pop(0)
                temp.append(node.val)
                if node.left != None:
                    q.append(node.left)
                
                if node.right != None:
                    q.append(node.right)
            result.append(temp)
        return result

