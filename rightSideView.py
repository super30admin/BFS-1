from collections import deque
class Solution(object):
    # Time Complexity : O(n), where n is the number of nodes in the tree.
    # Space Complexity : O(h), where h is the max height of the tree.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # This approach uses a dfs which goes from right to left and adds
    # all the right most nodes first and then for the other branches
    # adds the nodes only if they weren't added in the right most branch.
    def __init__(self):
        self.retVal = []

    def rightSideViewRecursive(self, root):
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

#------------------------------------------------------x---------------------------------------------------------------#

    # Time Complexity : O(n), where n is the number of nodes in the tree.
    # Space Complexity : O(n), where n is the number of nodes in the tree.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # This approach uses a bfs, keeping track of every level.
    # visiting nodes from left to right and for every level
    # add the last value to the resultant array.
    def rightSideViewIterative(self, root):
        if not root:
            return []
        retVal = []
        queue = deque()
        queue.appendleft(root)
        #BFS
        while len(queue) != 0:
            temp = None
            for i in range(len(queue)):
                curr = queue.pop()
                temp = curr.val
                if curr.left != None:
                    queue.appendleft(curr.left)

                if curr.right != None:
                    queue.appendleft(curr.right)
            retVal.append(temp)

        return retVal
