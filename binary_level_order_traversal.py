# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        answer = []
        if not root:
            return answer
        queue = []
        queue.append(root)
        while queue:
            temp = []
            for i in range(len(queue)):
                curr = queue.pop(0)
                temp.append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            answer.append(temp)
        return answer
            
#time complexity - O(n)

#space complexity - O(n)

#all test cases passed