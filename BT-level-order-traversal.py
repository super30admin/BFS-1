"""
Runtime Complexity:
O(n) - we traverse 'n' nodes in every level.
Space Complexity:
O(n) - queue might endup having 'n' nodes in the worst case. We dont account the space for result list because the problem statement expects list of list of integers.
Yes, the code worked on leetcode.
"""
from queue import Queue
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        result =[]
        q = Queue()
        q = [root]
        
        while q:
            size = len(q)
            list_= []
            for i in range(size):
                curr = q.pop(0)
                list_.append(curr.val)
                
                if curr.left!=None:
                    q.append(curr.left)
                    
                if curr.right!=None:
                    q.append(curr.right)
            
            result.append(list_)
        return result
        
        