# BFS Solution:
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        if root == None:
            return result
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            li = []
            for i in range(size):
                curr = q.popleft()
                li.append(curr.val)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)

            result.append(li)
        return result
# ***********************************************************************
# DFS Solution:
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
# Definition for a binary tree node.

class Solution:
    def __init__(self):
        self.result = []

    def levelOrder(self, root):
        if root == None: return []
        self.dfs(root, 0)
        return self.result

    def dfs(self, root, level):
        # base
        if root == None: return

        # logic
        if level == len(self.result):
            self.result.append([])

        self.result[level].append(root.val)

        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)


