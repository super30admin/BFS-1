# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if(root == None):
            return root
        
        queue = deque()
        output = []
        
        queue.append(root)
        
        while(queue):
            size = len(queue)
            
            for _ in range(0, size):
                top = queue.popleft()
                
                if(top.left is not None):
                    queue.append(top.left)
                
                if(top.right is not None):
                    queue.append(top.right)
                    
                if(_ == size - 1):
                    output.append(top.val)
        
        return output
