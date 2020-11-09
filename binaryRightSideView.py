#Time Complexity : O(n) where n is number of elements in the tree
#Space Complexity : O(n) where w is number of elements in the tree.

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Doing a BFS, we keep track of the last element using a variable which we keep overwriting at each level, as the last time it iterates each level before it exists the inner for loop, the last element will be the right most element of each level. And this variable at the end of level we store in an array which we return as the result.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        q = deque([root])

        rightView = []

        while q:
            for i in range(len(q)):
                curr = q.popleft()
                if curr:
                    if curr.left:
                        q.append(curr.left)
                    if curr.right:
                        q.append(curr.right)
                level = curr.val
            rightView.append(level)

        return rightView
