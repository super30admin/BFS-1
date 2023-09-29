# Time Complexity: O(n) where n is the number of nodes
# Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        q = deque()
        if root == None:
            return result
        q.append(root)
        while q:
            size = len(q)
            temp = []
            for _ in range(size):
                node = q.popleft()
                temp.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            result.append(temp)
        return result


########################################


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        self.result = []
        self.helper(root, 0)
        return self.result
    def helper(self, root, level):
        if root == None:
            return
        if(level) == len(self.result):
            self.result.append([])
        self.result[level].append(root.val)

        self.helper(root.left, level + 1)
        self.helper(root.right, level + 1)



##########################



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        self.helper(root, 0, result)
        return result
    def helper(self, root, level, result):
        if root == None:
            return
        if(level) == len(result):
            result.append([])
        result[level].append(root.val)

        self.helper(root.left, level + 1, result)
        self.helper(root.right, level + 1, result)