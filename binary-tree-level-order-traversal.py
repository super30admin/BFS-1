'''
Did it run on leetcode: yes
Did you faced any problem: No

Time Complexity: 0(N)
Space Compelxity: 0(N)

Algorithm:
- Just a simple level order traversal

'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []
        if not root:
            return result
        
        queue = [root]
        while queue:
            result.append([node.val for node in queue])
            size = len(queue)
            for i in range(size):
                node = queue[i]
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            queue = queue[size:]
        return result
        