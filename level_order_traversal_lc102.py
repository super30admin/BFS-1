"""
Name: Srinidhi 
Did it run on LC: Yes

Time Complexity: O(n) - Exploring all nodes
Space Complexity: O(n) - Output Structure contains all 

Logic: BFS- Level order traversal in tree maintain a queue
In the qu, add nodes in the order they are visited and add its children
at the end of the queue.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        
        ans = []
        qu = [root]
        level = 0
        while qu:
            ans.append([])
            lev_len = len(qu)
            
            for i in range(lev_len):
                
                node = qu.pop(0)
                ans[level].append(node.val)
                
                if node.left:
                    qu.append(node.left)
                
                if node.right:
                    qu.append(node.right)
            
            level+=1
            
        return ans