# Time Complexity : Add - O(n)
# Space Complexity :O(2^h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. I have recursively traversing left and right side while maintaining th level
2. All the val corresponded to a level is added to hashmap
'''
from collections import deque
class Solution:    
    def __init__(self):
        self.global_hashmap = {}
        
        
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        self._helper(root, -1)
        
        return self.global_hashmap.values()
                
    
    def _helper(self, root, level):
        
        if root is None:
            return 

        level += 1
        if level not in self.global_hashmap:
            self.global_hashmap[level] = [root.val]
        else:
            self.global_hashmap[level].append(root.val)
            
        self._helper(root.left, level)
        self._helper(root.right, level)