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
        if(root == None):
            return root
        
        queue = deque()
        queue.append(root)
        size = 0
        output = []
        
        while(queue):
            size = len(queue)
            temp = []
            
            for _ in range(0, size):
                top = queue.popleft()
                temp.append(top.val)
                
                if(top.left is not None):
                    queue.append(top.left)

                if(top.right is not None):
                    queue.append(top.right)
            
            output.append(temp)
        
        return output
