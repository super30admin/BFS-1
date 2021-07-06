from collections import deque
class Solution(object):
    # Time Complexity : O(n), where n is the number of nodes in the tree.
    # Space Complexity : O(h), stack space where h is the max height of the tree.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # This approach is recursive where a dfs is called on every
    # node and for every level append the node to the respective list.
    def __init__(self):
        self.retVal = []

    def levelOrderRecursive(self, root):
        if not root:
            return self.retVal
        self.dfs(root, 0)
        return self.retVal

    def dfs(self, root, level):
        if not root:
            return
        # adding new list if required
        if len(self.retVal) == level:
            self.retVal.append([])
        # appending to respective lists
        self.retVal[level].append(root.val)
        # recursive calls to children nodes
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)

#------------------------------------------------------x---------------------------------------------------------------#

    # Time Complexity : O(n), where n is the number of nodes in the tree.
    # Space Complexity : O(n), where n is the number of nodes in the tree.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    # This approach is done using a bfs where every level is added to
    # a temporary list and that list is added to the resultant list.
    def levelOrderIterative(self, root):
        retVal = []
        if not root:
            return retVal
        q = deque()
        q.appendleft(root)
        #bfs
        while len(q) != 0:
            temp = []
            # The q will only have one level in it at a time
            for i in range(len(q)):
                # add the level present in queue
                node = q.pop()
                temp.append(node.val)
                # add it's children to process next level.
                if node.left != None:
                    q.appendleft(node.left)
                if node.right != None:
                    q.appendleft(node.right)
            # add level to resultant list.
            retVal.append(temp)
        return retVal
