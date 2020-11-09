#Time Complexity : O(n) where n is number of elements in the tree
#Space Complexity :  O(n) where n is number of elements in the tree

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Starting with the root node in a queue traverse each level, appending values to a temp array and finally after traversing each level store temp array in resulting array.

#Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        q = deque([root])
        allLevels = []

        while q:
            level = []
            for _ in range(len(q)):
                curr = q.popleft()
                if curr:
                    if curr.left:
                        q.append(curr.left)
                    if curr.right:
                        q.append(curr.right)
                level.append(curr.val)

            allLevels.append(level)

        return allLevels
