# // Time Complexity : O(2^h) where n stand for length of the list
# // Space Complexity : O(2^h) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []
        queue = deque()
        queue.append(root)
        
        res = []
        
        while queue:
            size = len(queue)
            temp = []
            while size:
                top = queue.popleft()
                temp.append(top.val)
                if top.left: queue.append(top.left)
                if top.right: queue.append(top.right)
                size -= 1
            
            res.append(copy.deepcopy(temp))
            
        return res
                