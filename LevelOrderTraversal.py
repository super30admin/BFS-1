# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        # DFS has a Time Complexity of O(N) and space complexity of O(h)
        # Using DFS Approach
        # Use Stack to traverse each node and add element to the output based on 
        # the level
        if root is None:
            return []
        output = []
        stack = [(root,0)]
        while(stack):
            root,level = stack.pop()
            if(level == len(output)):
                output.append([root.val])
            else:
                output[level].append(root.val)
            if(root.right):
                stack.append((root.right,level+1))
            if(root.left):
                stack.append((root.left,level+1))
        return output