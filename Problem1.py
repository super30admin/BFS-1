
# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Binary Tree Level Order Traversal


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if root is None:
            return result

        que = deque([root])  # Use deque for efficient popping from the front

        while que:
            size = len(que)
            tmp_result = []
            for i in range(size):
                curr = que.popleft()  # O(1) operation
                tmp_result.append(curr.val)

                if curr.left is not None:
                    que.append(curr.left)
                if curr.right is not None:
                    que.append(curr.right)

            result.append(tmp_result)
        return result

        # result = []
        # if root == None:
        #     return result
        # que = [root]

        # while que:
        #     size = len(que)
        #     tmp_result = []
        #     for i in range(size):
        #         curr = que.pop(0)
        #         tmp_result.append(curr.val)
        #         if curr.left != None:
        #             que.append(curr.left)
        #         if curr.right != None:
        #             que.append(curr.right)
        #     result.append(tmp_result)
        # return result

    # Recursion Method
    #     self.result = []
    #     self.dfs(root, 0)
    #     return self.result

    # def dfs(self,root: Optional[TreeNode],level: int):
    #     if root == None:
    #         return
    #     if len(self.result) == level:
    #         self.result.append([])
    #     self.result[level].append(root.val)

    #     self.dfs(root.left, level+1)
    #     self.dfs(root.right, level+1)

        

