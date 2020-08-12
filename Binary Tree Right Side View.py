# Time Complexity : O(n) where n is the maximum element in a list
# Space Complexity : O(w) where w is the max width of the tree / max number of node in any level
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# we do a level order traversal
# we will add the last element from each level order

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:

        if root is None:
            return []

        result = []

        q = deque()

        q.append(root)

        while q:

            qSize = len(q)

            current = None

            for node in range(qSize):

                current = q.popleft()

                if current.left:
                    q.append(current.left)

                if current.right:
                    q.append(current.right)

            result.append(current.val)

        return result