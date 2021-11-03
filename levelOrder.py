# Time Complexity : O(n) 
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        levelTraverse = []
        if root is None:
            return levelTraverse
        q = deque([root,])
        level = 0
        while q:
            size = len(q)
            levelTraverse.append([])
            for i in range(size):
                ele = q.popleft()
                levelTraverse[level].append(ele.val)
                if ele.left is not None:
                    q.append(ele.left)
                if ele.right is not None:
                    q.append(ele.right)
            level +=1
        return levelTraverse
