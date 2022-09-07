# // Time Complexity : O(n) each node is processed once
# // Space Complexity : O(n) since the output structure contains n node values - i.e. level arrays
# // Did this code successfully run on Leetcode : yes
# // Three line explanation of solution in plain english: first we append root to queue. Then while queue is
# not empty, we declare empty level array and loop over queue. Pop the first element in the queue and add to 
# level array. then we process the particular node, if it has left or right childre, we add them to queue.
# after all nodes in a level are processed, add the level array to final result array



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        level=0
        if not root:
            return []
        q, levels=deque([root]), []
        
        while q:
            level=[]
            for i in range(len(q)):
                node=q.popleft()
                level.append(node.val)

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            levels.append(level)
        return levels