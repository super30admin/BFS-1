'''
Time: O(n)
Space: O(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return None
        queue=deque()
        queue.append(root)
       
        res=[]
        while queue:
            levels=[]
            size=len(queue)
            for i in range(0,size):
                current=queue.popleft()
                if current.left is not None:
                    queue.append(current.left)

                if current.right is not None:
                    queue.append(current.right)
                levels.append(current.val)
            res.append(levels)

        return res