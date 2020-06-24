# Time Complexity : O(n), where n is the number of nodes in the tree.
# Space Complexity : O(h),  where h is the max height of the tree.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
class Solution(object):
    def __init__(self):
        self.retVal = []

    # This approach uses a dfs which goes from right to left and adds
    # all the right most nodes first and then for the other branches
    # adds the nodes only if they weren't added in the right most branch.
    def rightSideView(self, root):
        if not root:
            return []
        self.dfs(root, 0)
        return self.retVal

    def dfs(self, root, level):
        if not root:
            return
        # adding to list if necessary
        if len(self.retVal) == level:
            self.retVal.append(root.val)
        # recursive calls to children nodes
        self.dfs(root.right, level + 1)
        self.dfs(root.left, level + 1)
