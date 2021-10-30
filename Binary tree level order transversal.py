# TC - O(n)
# SC - O(n)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        output = []
        queue = deque()
        queue.append(root)
        while (queue):
            sz = len(queue)
            innerlist = []
            for i in range(sz):
                ele = queue.popleft()
                innerlist.append(ele.val)
                if ele.left:
                    queue.append(ele.left)
                if ele.right:
                    queue.append(ele.right)
            output.append(innerlist)
        return output
