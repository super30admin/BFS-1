#Time: O(n)
#space: O( h- size of recursive stack)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        self.level_list= list(list())
        self.dfs(root,0)
        return self.level_list

    def dfs(self, root,lvl):
        if root is None:
            return
        
        while len(self.level_list) <= lvl:
            self.level_list.append([])
        self.dfs(root.left, lvl + 1)
        self.dfs(root.right, lvl + 1)
        if self.level_list[lvl] == []:
            self.level_list[lvl] = [root.val]
        else:
            temp= self.level_list[lvl]
            temp.append(root.val)
            self.level_list[lvl] = temp
