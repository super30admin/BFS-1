# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        def dfs(node, level):       #2nd parameter "i.e level" is the height of the tree
            if not node:  # condtion is root is null it will return nothing
                return

            if len(self.result) <= level:  #if result is equal to or less than level it implies that at that level result does not corresponding list
                self.result.append([])        #to add list at the correspond level
            self.result[level].append(node.val)       # at this level there is a list  and appending to that list the node value(root value)

            dfs(node.left, level + 1)
            #st.pop: root = , level
            dfs(node.right, level + 1)
            # st.pop

        self.result = []
        dfs(root, 0)  # dfs at root initial level is zero

        return self.result
