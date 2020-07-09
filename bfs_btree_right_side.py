# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#BFS
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        ans = []
        if not root:
            return ans
        queue = []
        queue.append(root)
        while queue:
            temp = 0
            for i in range(len(queue)):
                curr = queue.pop(0)
                temp = curr.val
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            ans.append(temp)
        return ans


#time complexity = O(n) as every node is traversed

#space complexity = O(n/2), the max nodes possible in 1 level ~ O(n)

#all test cases passed