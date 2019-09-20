# leetcode:accepted
# timecoplexity: o(n)
# no doubts
# explaination: BAsic idea
# if the level is equal to the length of the result, then you add a new list to the result and then add the root value
# if the level is lesser than the root value, it means the list pertaining to the levsl is already exisitng, so you just go to the respecive list and add the value

# you call the dfs methid recursively to the left and right and everytime you call you increase the level


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        level = 0
        self.dfs(root, result, 0)
        return result

    def dfs(self, root, result, level):
        if root == None:
            return
        if len(result) == level:
            result.append(list())

        result[level].append(root.val)
        self.dfs(root.left, result, level + 1)
        self.dfs(root.right, result, level + 1)
        # return result
