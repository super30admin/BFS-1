# 102. Binary Tree Level Order Traversal

'''
Leetcode all test cases passed: Yes
Solution:
    n is no of nodes in the tree
    def levelOrder(self, root):
        Space Complexity: O(n) 
        Time Complexity: O(n / 2) = O(n)
'''
from collections import deque
class Solution:
    def levelOrder(self, root):
        res = []
        if not root:
            return res
        queue = deque([root])
        res.append([root.val])
        while queue:
            temp_res = []
            for i in range(len(queue)):
                curr = queue.popleft()
                
                if curr.left != None:
                    temp_res.append(curr.left.val)
                    queue.append(curr.left)
                if curr.right != None:
                    temp_res.append(curr.right.val)
                    queue.append(curr.right)
            if len(temp_res) > 0:
                res.append(temp_res)
        return res
