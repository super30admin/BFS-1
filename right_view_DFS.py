# Time Complexity : Add - O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. I have recursively traversing right side first and then left side
2. If len of result is less than the level+1, then I am adding that ellement to it
3. If not, the element from right subtree is already added
'''

class Solution:
        
    def __init__(self):
        self.result = []
        
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        self._helper(root, -1)
        return self.result
        
    def _helper(self, root, level):
        
        if root is None:
            return
        
        level += 1
        
        if len(self.result) < (level+1):
            self.result.append(root.val)
                
         
        self._helper(root.right, level)
        self._helper(root.left, level)
        
    